package com.taoxue.base;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.taoxue.umeng.base.HjjApplication;
import com.taoxue.umeng.http.HttpAdapter;
import com.umeng.socialize.PlatformConfig;

/**
 * @author 侯建军
 * @data on 2018/1/11 17:09
 * @org www.hopshine.com
 * @function 请填写
 * @email 474664736@qq.com
 */

public class BaseApplication extends HjjApplication {
    {
        PlatformConfig.setWeixin("wx68db7c9878c023fc", "a573cc30a913b9b60a01401732d685b0");
        PlatformConfig.setQQZone("101397990", "371e2e7907573ea21f793e107c3890a3");
    }
    public RefWatcher refWatcher;//用于内存泄漏
    @Override
    public void onCreate() {
        super.onCreate();
        HttpAdapter.init();
        refWatcher= LeakCanary.install(this);
    }
}
