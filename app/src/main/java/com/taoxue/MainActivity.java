package com.taoxue;

import android.Manifest;
import android.os.Bundle;
import android.view.View;

import com.taoxue.base.BaseActivity;
import com.taoxue.umeng.utils.UPermissionsTool;
import com.taoxue.umeng.utils.Uintent;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPermission();
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
}
