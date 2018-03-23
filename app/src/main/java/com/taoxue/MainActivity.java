package com.taoxue;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.taoxue.base.BaseActivity;
import com.taoxue.umeng.utils.UPermissionsTool;
import com.taoxue.umeng.utils.Uintent;
import com.taoxue.umeng.utils.Ulog;

public class MainActivity extends BaseActivity {
    private int index;
    Handler handler = new Handler();

    public class MyRunnable implements Runnable {

        @Override
        public void run() {
            index++;
            index = index % 3;
            Ulog.i("index", index);
            handler.postDelayed(myRunnable, 1000);
        }
    }
    MyRunnable myRunnable = new MyRunnable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPermission();
        handler.postDelayed(myRunnable, 1000);

        new Thread(){
            @Override
            public void run() {
                Ulog.i("Thread", currentThread().getName());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Ulog.i("Thread", currentThread().getName());
                    }
                });
            }
        }.start();

    }


    /**
     * 获取权限
     */
    private void getPermission() {

        UPermissionsTool.
                getIntance(this).
                addPermission(Manifest.permission.ACCESS_FINE_LOCATION).
                addPermission(Manifest.permission.ACCESS_COARSE_LOCATION).
                addPermission(Manifest.permission.READ_EXTERNAL_STORAGE).
                addPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE).
                addPermission(Manifest.permission.CAMERA).
                addPermission(Manifest.permission.CALL_PHONE).
                addPermission(Manifest.permission.READ_PHONE_STATE).
                initPermission();
    }

    public void toLoginSharePay(View view) {
        Uintent.intentDIY(this, LoginActivity.class);
    }

    public void toWebActivity(View view) {
        Uintent.intentDIY(this, WebBaseActivity.class);
    }

    public void toMyCollectActivity(View view) {
        Uintent.intentDIY(this, MyCollectActivity.class);
    }
}
