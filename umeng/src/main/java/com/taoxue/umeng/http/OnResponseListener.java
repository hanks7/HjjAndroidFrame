package com.taoxue.umeng.http;

import android.content.Context;
import android.text.TextUtils;

import com.taoxue.umeng.model.BaseResultModel;
import com.taoxue.umeng.utils.UT;
import com.taoxue.umeng.view.LoadingDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CC on 2016/5/28.
 */
public abstract class OnResponseListener<T> implements Callback<T> {

    LoadingDialog dialog;

    public OnResponseListener(Context context) {
        dialog = new LoadingDialog(context);
        if (needDialog())
            dialog.show();
    }

    protected boolean needDialog() {
        return true;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.code() == 200) {
            if (response.body() instanceof BaseResultModel) {

                BaseResultModel commonBean = (BaseResultModel) response.body();
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
        dismiss();
    }

    protected void onRequestFailure() {

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        dismiss();
        String msg = t.getMessage();
        if (TextUtils.isEmpty(msg))
            msg = "请求异常";
        UT.s(msg);
        onRequestFailure();
    }

    protected void onFailure(int code) {
        UT.s("请求异常:" + code);
    }

    protected void onFailure(String msg) {
        UT.s(msg);
    }

    protected abstract void onSuccess(T t);

    public void dismiss() {
        try {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}