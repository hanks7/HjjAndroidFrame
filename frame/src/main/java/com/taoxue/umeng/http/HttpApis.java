package com.taoxue.umeng.http;


import com.taoxue.umeng.base.BaseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CC on 2016/5/28.
 */

public interface HttpApis {



    /**
     * 根据所在城市查询对应的采购商（图书馆）
     *
     * @param city
     * @return
     */
    @GET("mt/city/cgs.do")
    Call<BaseModel> searchCgs(@Query("city") String city);

    /**
     * 资源库详情接口
     *
     * @return
     */
    @GET("mt/drdata/info.do")
    Call<BaseModel> searchInfo();


    /**
     * 手机端推荐资源库关键词接口：搜索资源库时使用
     *
     * @return
     */
    @GET("mt/commend/keyword/resource.do")
    Call<BaseModel> searchResource();

    /**
     * 手机端推荐关键词接口：搜索资源时使用
     *
     * @return
     */
    @GET("mt/commend/keyword/resource.do")
    Call<BaseModel> searchResource2();


}
