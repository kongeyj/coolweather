package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.coolweather.android.gson.AQI;
import com.coolweather.android.gson.Forecast;
import com.coolweather.android.gson.NowWeather;
import com.coolweather.android.gson.Suggest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class Utility {


    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();

                }
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setProvinceId(provinceId);
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.save();

                }
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county=new County();
                   county.setCountyName(countyObject.getString("name"));
                   county.setWeatherId(countyObject.getString("weather_id"));
                   county.setCityId(cityId);
                    county.save();

                }
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    private static Gson gson=new Gson();
    public static Forecast handleForecastResponse(String response) {
        try {
            Forecast forecast = gson.fromJson(response, Forecast.class);
            return forecast;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AQI handleAQIResponse(String response) {
        try {
            AQI aqi = gson.fromJson(response, AQI.class);
            return aqi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Suggest handleSuggestResponse(String response) {
        try {
            Suggest suggest = gson.fromJson(response, Suggest.class);
            return suggest;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static NowWeather handleNowWeatherResponse(String response) {
        try {
            NowWeather nowWeather = gson.fromJson(response, NowWeather.class);
            return nowWeather;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}


