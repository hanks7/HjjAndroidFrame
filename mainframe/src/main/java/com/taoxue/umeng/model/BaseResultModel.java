package com.taoxue.umeng.model;

import com.taoxue.umeng.base.BaseModel;

import java.io.Serializable;

/**
 * Created by CC on 2016/12/11.
 */

public class BaseResultModel<Data extends Serializable> extends BaseModel {
    private Data data;// {

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
