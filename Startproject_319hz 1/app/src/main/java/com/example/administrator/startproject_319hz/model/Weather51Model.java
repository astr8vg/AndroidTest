package com.example.administrator.startproject_319hz.model;

import com.example.administrator.startproject_319hz.bean.WeatherResult;
import com.example.administrator.startproject_319hz.iface.WeatherIface;
import com.example.administrator.startproject_319hz.iface.WeatherListener;
import com.example.administrator.startproject_319hz.service.Weather51Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/14.
 */

public class Weather51Model implements WeatherIface{
    private String BASEURL="http://weather.51wnl.com/weatherinfo/";
    private Retrofit retrofit;
    public Weather51Model() {
//Retrofit实例化  3-1
        retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL) //主机地址
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        Weather51Service weather51Service = retrofit.create(Weather51Service.class);
        Call<WeatherResult> call = weather51Service.getResult(cityno,1);
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if (response.isSuccessful()&& response.body()!=null){
                    listener.onResponse(response.body().getWeatherinfo());

                }else{
                    listener.onFail("onResponse error");
                }
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {

            }
        });
    }
}
