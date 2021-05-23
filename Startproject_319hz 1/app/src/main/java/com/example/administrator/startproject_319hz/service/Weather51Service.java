package com.example.administrator.startproject_319hz.service;

        import com.example.administrator.startproject_319hz.bean.WeatherResult;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/3/14.
 */

public interface Weather51Service {
    @GET("GetMoreWeather")
    Call<WeatherResult> getResult(@Query("cityCode") String cityCode,@Query("weatherType") int weatherType);
}
