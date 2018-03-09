package com.taoxue.umeng.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.taoxue.umeng.base.BaseModel;

import java.lang.reflect.Type;

/**
 * Created by liu on 15/5/29.
 * 解析Gson数据格式
 */
public class UGson {


    public static BaseModel fromJson(String gsonStr, Type type) {

        try {
            if (gsonStr == null) return null;
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(gsonStr, type);
        } catch (Exception e) {
            e.printStackTrace();
            UToast.showText(e + "解析json错误,后台修改json字段,造成异常");
            return null;
        }

    }

    public static String toJson(Object obj) {
        try {
            if (obj == null) return null;
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(obj);
        } catch (Exception e) {
            //Log.e("TEST", " exception , " + ex.getMessage());
            UToast.showText(e + "");
            return null;
        }
    }
}
