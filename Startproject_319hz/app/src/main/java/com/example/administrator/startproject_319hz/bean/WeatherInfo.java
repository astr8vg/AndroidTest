package com.example.administrator.startproject_319hz.bean;

/**
 * Created by Administrator on 2017/3/14.
 */

public class WeatherInfo {
    private String city;
    private String cityid;
    private String temp;
    private String WD;
    private String WS;
    private String SD;


    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

}
