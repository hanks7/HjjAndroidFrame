package com.taoxue.umeng.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.danikula.videocache.HttpProxyCacheServer;
import com.taoxue.umeng.base.HjjApplication;


/**
 * Created by User on 2017/4/17.
 */

public class UtilTools {
    public static Context context = HjjApplication.getInstance();


    public static String getResourcesString(int id) {
        return context.getResources().getString(id);
    }

    public static float getResourcesDimension(int id) {
        return context.getResources().getDimension(id);
    }


    /**
     * 设置textview 的左边的图片
     * @param tv
     * @param mipmapID
     */
    public static void setTvDrawable(Context context,TextView tv, int mipmapID) {
        Drawable drawable= context.getResources().getDrawable(mipmapID);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawablePadding(11);//设置图片和text之间的间距
        tv.setCompoundDrawables(drawable,null,null,null);
    }

    /**
     * 带 X 图标的 输入框 有文字 显示x 没文字 x消失
     *
     * @param sEdtInput
     * @param sIvClear
     */
    public static void clearEditText(final EditText sEdtInput, final ImageView sIvClear) {

        sIvClear.setVisibility(View.INVISIBLE);
        sEdtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    sIvClear.setVisibility(View.VISIBLE);
                } else {
                    sIvClear.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        sIvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sEdtInput.setText("");
            }
        });
    }



    /**
     * 播放音频或者视频的缓存路径.
     * @param url
     * @return
     */
    public static  String getProxyUrl(String url) {
        HttpProxyCacheServer proxy = HjjApplication.getProxy();
        return proxy.getProxyUrl(url);
    }

}
