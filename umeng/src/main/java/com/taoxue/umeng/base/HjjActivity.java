package com.taoxue.umeng.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.taoxue.umeng.utils.UL;
import com.taoxue.umeng.utils.permission.PermissionReq;

public class HjjActivity extends AppCompatActivity {
    public HjjActivity mActivity;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionReq.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=this;

    }

    @Override
    protected void onResume() {
        super.onResume();
        UL.e("activity", getLocalClassName());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        HjjApplication.getInstance().refWatcher.watch(this);
    }

    @Override
    public void onBackPressed() {
        dealOnBackPressed();
        super.onBackPressed();
    }
    public void dealOnBackPressed() {
    }
}
