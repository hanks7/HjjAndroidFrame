package com.taoxue.umeng.http;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CC on 2016/5/28.
 */
public abstract class OnResponseNoDialogListener2<T> implements Callback<T> {
    public OnResponseNoDialogListener2() {
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onSuccess(null);
    }

    protected void onRequestFailure() {
        onSuccess(null);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onSuccess(null);
    }


    /**
     *
     */
    protected void onFailure() {
    }



    protected abstract void onSuccess(T t);

}