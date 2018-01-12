package com.taoxue.umeng.utils;

import android.os.Environment;

import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.taoxue.umeng.R;
import com.taoxue.umeng.base.HjjApplication;

import java.io.File;

/**
 * @author 侯建军
 * @data on 2018/1/12 10:45
 * @org www.hopshine.com
 * @function 请填写
 * @email 474664736@qq.com
 */

public class Upath {
    public static String getAppCachePath() {
        String path = HjjApplication.getInstance().getCacheDir() + "/"+ InternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }
    public static String getDownLoadPath() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/"+HjjApplication.getInstance().getString(R.string.file_path);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }
}
