package com.taoxue.http;


import com.taoxue.bean.QryMyCollectionBean;
import com.taoxue.umeng.base.BaseModel;
import com.taoxue.umeng.model.BasePageModel;

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
     * 我的收藏
     *
     * @return
     */
    @GET("mt/h5/20/member/qryMyCollection.do?pageSize=10")
    Call<BasePageModel<QryMyCollectionBean>> collection3(@Query("pageNo") int page);


}
