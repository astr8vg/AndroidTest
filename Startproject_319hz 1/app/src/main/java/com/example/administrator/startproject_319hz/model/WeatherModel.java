package com.example.administrator.startproject_319hz.model;


import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.startproject_319hz.bean.WeatherResult;
import com.example.administrator.startproject_319hz.iface.WeatherIface;
import com.example.administrator.startproject_319hz.iface.WeatherListener;
import com.example.administrator.startproject_319hz.service.WeatherService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/14.
 */

public class WeatherModel implements WeatherIface{
    private Retrofit retrofit;
    private String BASEURL="http://www.weather.com.cn/";

    public WeatherModel() {
        //Retrofit实例化  3-1
        retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL) //主机地址
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        //Retrofit接口使用
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<WeatherResult>  call = weatherService.getResult(cityno);
        call.enqueue(new Callback<WeatherResult>() {


            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listener.onResponse(response.body().getWeatherinfo());
                }else{
                    listener.onFail("onResponse error");
                }

            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
