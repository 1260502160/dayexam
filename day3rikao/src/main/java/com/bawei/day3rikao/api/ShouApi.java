package com.bawei.day3rikao.api;

import com.bawei.day3rikao.bean.Bean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShouApi {

    @POST("small/commodity/v1/findCommodityByKeyword")
    @FormUrlEncoded
    Call<Bean> show (@Field("name")String name,@Field("page")String page,@Field("count")String count);

    @GET("small/commodity/v1/findCommodityByKeyword")
    Call<Bean> shou (@Query("keywork")String name,@Query("page")int page,@Query("count")int count);


}
