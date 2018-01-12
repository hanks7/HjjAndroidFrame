package com.taoxue.umeng.base;

import android.app.Application;

import com.danikula.videocache.HttpProxyCacheServer;
import com.taoxue.umeng.utils.Upath;
import com.umeng.socialize.Config;
import com.umeng.socialize.UMShareAPI;

import java.io.File;

/**
 * @author 侯建军
 * @data on 2018/1/10 10:56
 * @org www.hopshine.com
 * @function 请填写
 * @email 474664736@qq.com
 */

public class HjjApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        UMShareAPI.get(this);//初始化sdk
        Config.DEBUG = true;//开启debug模式，方便定位错误，具体错误检查方式可以查看http://dev.umeng.com/social/android/quick-integration的报错必看，正式发布，请关闭该模式
    }

    public static HjjApplication application;

    public static HjjApplication getInstance() {
        return application;
    }

    //********************************************缓存*******************************************************
    private HttpProxyCacheServer proxy;
    public static HttpProxyCacheServer getProxy() {
        return application.proxy == null ? (application.proxy = application.newProxy()) : application.proxy;
    }
    /**
     * 创建缓存代理服务,带文件目录的.
     */
    private HttpProxyCacheServer newProxy() {
        HttpProxyCacheServer.Builder builder = new HttpProxyCacheServer.Builder(this);
        builder.cacheDirectory(new File(Upath.getAppCachePath()));
        return builder.build();
    }
    //********************************************缓存*******************************************************
}

