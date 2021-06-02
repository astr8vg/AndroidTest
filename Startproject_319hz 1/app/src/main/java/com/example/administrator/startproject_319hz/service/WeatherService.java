package com.example.administrator.startproject_319hz.service;

import com.example.administrator.startproject_319hz.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/3/14.
 */
//Retrofit 访问网络————2.定义接口
public interface WeatherService {
    @GET("data/sk/{cityNumber}.html")
    Call<WeatherResult>  getResult(@Path("cityNumber")String cityNumber);
}
