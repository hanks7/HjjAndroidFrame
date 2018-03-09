package com.taoxue;

import android.os.Bundle;
import android.webkit.JavascriptInterface;

import com.taoxue.base.BaseActivity;
import com.taoxue.umeng.view.LoadingDialog;
import com.taoxue.umeng.view.ProgressBarWebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebBaseActivity extends BaseActivity {
    @BindView(R.id.lib_home_web_view)
    public ProgressBarWebView mWebView;


    LoadingDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_base);
        ButterKnife.bind(this);
        dialog = new LoadingDialog(this);
        mWebView.loadUrl("https://www.baidu.com/");
    }


    /**
     * 由于安全原因 targetSdkVersion>=17需要加 @JavascriptInterface
     * JS调用Android JAVA方法名和HTML中的按钮 onclick后的别名后面的名字对应
     *
     * window.android.showDialog(1) //打开dialog
     * window.android.showDialog(0) //关闭dialog
     */
    @JavascriptInterface
    public void showDialog(final String type) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (Integer.valueOf(type)) {
                    case 0://关闭dialog
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        break;
                    case 1://打开dialog
                        dialog.show();
                        break;
                }

            }
        });
    }




}
