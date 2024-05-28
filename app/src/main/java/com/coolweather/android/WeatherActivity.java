package com.coolweather.android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.coolweather.android.databinding.ActivityWeatherBinding;
import com.coolweather.android.gson.AQI;
import com.coolweather.android.gson.BingPic;
import com.coolweather.android.gson.Forecast;
import com.coolweather.android.gson.NowWeather;
import com.coolweather.android.gson.Suggest;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.Utility;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
ActivityWeatherBinding binding;
    public static final String FORECAST_URL="https://devapi.qweather.com/v7/weather/7d";
    public static final String AQI_URL="https://devapi.qweather.com/v7/air/now";
    public static final String SUGGEST_URL="https://devapi.qweather.com/v7/indices/1d";
    public static final String NOWEATHER_URL="https://devapi.qweather.com/v7/weather/now";
    public static final String KEY="48eded087f314b1ea7e68b69f6c121a9";
    private String current_province;
    private String current_city;
    private String current_county;
    private  String type="1,3,8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }



        binding = ActivityWeatherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=getIntent();
        String weatherId = intent.getStringExtra("weather_id");
        current_province=intent.getStringExtra("current_province");
        current_city=intent.getStringExtra("current_city");
        current_county=intent.getStringExtra("current_county");
        binding.includeTitle.titleCity.setText(String.format("%s %s %s",current_province,
                current_city,current_county));
        //CNxxxx 需要把CN去掉
        weatherId=weatherId.substring(2);

//        binding.weatherLayout.setVisibility(View.INVISIBLE);
        requestWeather(weatherId);
        loadBingPic();

    }

    private void loadBingPic() {
       String url="https://api.xygeng.cn/openapi/bing/";
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(WeatherActivity.this, "获取Bing每日图片失败",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                BingPic bingPic = new Gson().fromJson(result,BingPic.class);
                Log.d("TAG123", result);
                runOnUiThread(()->{
                    if(bingPic!=null&&bingPic.getCode()==200){
                        //加载图片
                        Glide.with(WeatherActivity.this).load(bingPic.getData().getUrl()).into(binding.bingPicImg);
                    }else{
                        Toast.makeText(WeatherActivity.this, "获取Bing每日图片失败",
                                Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

    }

    private void requestWeather(String location) {
        loadBingPic();
        String url0 = NOWEATHER_URL + "?" + "location=" + location + "&key=" + KEY;
        HttpUtil.sendOkHttpRequest(url0, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(WeatherActivity.this, "获取当前天气信息失败",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                NowWeather nowWeather = Utility.handleNowWeatherResponse(result);
                Log.d("TAG23", result);
                showNowWeatherInfo(nowWeather);



            }
        });


        String url1 = FORECAST_URL + "?" + "location=" + location + "&key=" + KEY;
        HttpUtil.sendOkHttpRequest(url1, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(WeatherActivity.this, "获取天气信息失败",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                Forecast forecast = Utility.handleForecastResponse(result);
                Log.d("TAG234", result);
                showForecastInfo(forecast);



            }
        });
        String url2 = AQI_URL + "?" + "location=" + location + "&key=" + KEY;
        HttpUtil.sendOkHttpRequest(url2, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(WeatherActivity.this, "获取天气信息失败",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                AQI aqi = Utility.handleAQIResponse(result);

                Log.d("TAG23456", result);
                showAQIInfo(aqi);
            }
        });
        String url3 = SUGGEST_URL + "?" + "location=" + location + "&key=" + KEY + "&type=" + type;
        HttpUtil.sendOkHttpRequest(url3, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(WeatherActivity.this, "获取天气信息失败",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                Suggest suggest = Utility.handleSuggestResponse(result);

                Log.d("TAG2345666", result);
                showSuggestInfo(suggest);

                Log.d("TAG2345666", suggest.toString());
            }
        });

    }

    private void showNowWeatherInfo(NowWeather nowWeather) {
        runOnUiThread(()->{
            if(nowWeather!=null&&nowWeather.getCode().equals("200")){
                String temp = nowWeather.getNow().getTemp();
                binding.includeNow.weatherInfoText.setText(nowWeather.getNow().getText());
                binding.includeNow.degreeText.setText(String.format("%s ℃ ",
                        temp));
            }else{
                Toast.makeText(this, "获取实时天气信息出错！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showSuggestInfo(Suggest suggest) {
        runOnUiThread(()->{
            if(suggest!=null&& suggest.getCode().equals("200")){
                binding.includeSuggestion.comfortText.setText(String.format("舒适度指数：\n %s \n %s",
                        suggest.getDaily().get(2).getCategory(),
                        suggest.getDaily().get(2).getText()));
                binding.includeSuggestion.sportText.setText(String.format("运动指数：\n %s \n %s",
                        suggest.getDaily().get(0).getCategory(),
                        suggest.getDaily().get(0).getText()));
                binding.includeSuggestion.wearText.setText(String.format("穿衣指数：\n %s \n %s",
                        suggest.getDaily().get(1).getCategory(),
                        suggest.getDaily().get(1).getText()));
            }else{
                Toast.makeText(this, "获取天气指数出错！", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void showAQIInfo(AQI aqi) {
        runOnUiThread(()->{
            if(aqi!=null&&aqi.getCode().equals("200")){
                binding.includeAqi.aqiText.setText(aqi.getNow().getAqi());
                binding.includeAqi.pm25Text.setText(aqi.getNow().getPm2p5());
            }else{
                Toast.makeText(this, "获取实时空气质量出错！", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void showForecastInfo(Forecast forecast) {
        runOnUiThread(()->{
            if(forecast!=null&&forecast.getCode().equals("200")){
                binding.includeForecast.forecastLayout.removeAllViews();
                for (Forecast.DailyDTO dailyDTO : forecast.getDaily()) {
                    View view = LayoutInflater.from(this).inflate(R.layout.forecast_item,
                            binding.includeForecast.forecastLayout , false);
                    TextView dateText = (TextView) view.findViewById(R.id.date_text);
                    TextView infoText = (TextView) view.findViewById(R.id.info_text);
                    TextView maxText = (TextView) view.findViewById(R.id.max_text);
                    TextView minText = (TextView) view.findViewById(R.id.min_text);
                    dateText.setText(dailyDTO.getFxDate());
                    infoText.setText(dailyDTO.getTextDay());
                    maxText.setText(dailyDTO.getTempMax());
                    minText.setText(dailyDTO.getTempMin());
                    binding.includeForecast.forecastLayout.addView(view);
                }
            }else{
                Toast.makeText(this, "获取未来7天天气预报出错！", Toast.LENGTH_SHORT).show();
            }

        });

    }
}