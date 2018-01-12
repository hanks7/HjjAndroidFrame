package com.taoxue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.taoxue.base.BaseActivity;
import com.taoxue.umeng.utils.ShareUtils;
import com.taoxue.umeng.utils.UL;
import com.taoxue.umeng.utils.UT;
import com.taoxue.umeng.utils.Uintent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;


public class LoginActivity extends BaseActivity {
    public static String url = "https://mobile.umeng.com/";
    public static String text = "友盟微社区sdk，多终端一社区，为您的app添加社区就是这么简单";
    public static String title = "友盟微社区";
    public static String imageurl = "http://dev.umeng.com/images/tab2_1.png";
    public static String videourl = "http://video.sina.com.cn/p/sports/cba/v/2013-10-22/144463050817.html";
    public static String musicurl = "http://music.huoxing.com/upload/20130330/1364651263157_1085.mp3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * 授权
     * @param share_media
     */
    private void authorization(SHARE_MEDIA share_media) {
        UMShareAPI.get(this).getPlatformInfo(this, share_media, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                UL.e("onComplete " + "授权开始");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                 UL.e("onComplete " + "授权完成");

                //sdk是6.4.4的,但是获取值的时候用的是6.2以前的(access_token)才能获取到值,未知原因
                String uid = map.get("uid");
                String openid = map.get("openid");//微博没有
                String unionid = map.get("unionid");//微博没有
                String access_token = map.get("access_token");
                String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
                String expires_in = map.get("expires_in");
                String name = map.get("name");
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");
                UT.s(name+""+gender+""+gender+""+access_token);

                for (Map.Entry<String, String> entry : map.entrySet()) {
                    UL.e("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                }

                //拿到信息去请求登录接口。。。
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                 UL.e("onError " + "授权失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                 UL.e("onCancel " + "授权取消");
            }
        });
    }
    /**
     * qq第三方登录
     *
     * @param v
     */
    public void btnQQClick(View v) {
        authorization(SHARE_MEDIA.QQ);
    }

    /**
     * 微信第三方登录
     *
     * @param v
     */
    public void btnWXClick(View v) {
        authorization(SHARE_MEDIA.WEIXIN);
    }

    /**
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 分享测试
     * @param view
     */
    public void qqShare(View view) {
        ShareUtils.shareWeb(this, url, title
                , text, imageurl, R.mipmap.ic_launcher, SHARE_MEDIA.QQ
        );
    }

    public void payClick(View view) {
        Uintent.intentDIY(this,TestActivity.class);
    }
}
