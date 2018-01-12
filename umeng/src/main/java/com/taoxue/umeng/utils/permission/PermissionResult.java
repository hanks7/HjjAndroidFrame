package com.taoxue.umeng.utils.permission;

public interface PermissionResult {
    void onGranted();

    void onDenied();
    void onNext();
}
