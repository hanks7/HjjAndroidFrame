package com.taoxue.umeng.utils;

import android.widget.Toast;

import com.taoxue.umeng.base.HjjApplication;
/**
 * @author 侯建军
 * @data on 2018/1/4 11:03
 * @org www.hopshine.com
 * @function 请填写
 * @email 474664736@qq.com
 */

public class UT {
    // 构造方法私有化 不允许new对象
    private UT() {
    }

    // Toast对象
    private static Toast toast = null;

    /**
     * 显示Toast
     */
    public static void s(Object strToast) {
        UL.e("Toast    "+strToast);
        if (toast == null) {
            toast = Toast.makeText(HjjApplication.getInstance(), "", Toast.LENGTH_SHORT);
        }
        toast.setText(strToast+"");
        toast.show();
    }
}
