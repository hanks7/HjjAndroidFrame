package com.taoxue.umeng.http;

import android.text.TextUtils;

import com.taoxue.umeng.base.BaseModel;
import com.taoxue.umeng.utils.UToast;
import com.taoxue.umeng.utils.Ulog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CC on 2016/5/28.
 */
public abstract class OnResponseNoDialogListener<T> implements Callback<T> {
    public OnResponseNoDialogListener() {
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.code() == 200) {
            if (response.body() instanceof BaseModel) {
                BaseModel commonBean = (BaseModel) response.body();
                if (commonBean.getCode() == 1) {
                    onSuccess((T) commonBean);
                } else {
                    onFailure(commonBean.getMsg());
                }
            } else {
                onSuccess(response.body());
            }
        } else {
            onFailure(response.code());
            onRequestFailure();
        }
    }

    protected void onRequestFailure() {
        onFailure();
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailure();
        Ulog.e(t.getMessage());
        String msg = t.getMessage();
        if (TextUtils.isEmpty(msg))
            msg = "请求异常";
        UToast.showText(msg);
        onRequestFailure();
    }

    protected void onFailure(int code) {
        onFailure();
        UToast.showText("请求异常:" + code);
    }

    /**
     *
     */
    protected void onFailure() {
    }


    protected void onFailure(String msg) {
        UToast.showText(msg);
        onFailure();
    }

    protected abstract void onSuccess(T t);

}