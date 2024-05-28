package com.coolweather.android;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.coolweather.android.databinding.ActivityTestBinding;
import com.coolweather.android.gson.AQI;
import com.coolweather.android.gson.Forecast;
import com.coolweather.android.gson.Suggest;
import com.coolweather.android.util.HttpUtil;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TestActivity extends AppCompatActivity {
    ActivityTestBinding binding;
    Gson gson=new Gson();

    public static final String FORECAST_URL="https://devapi.qweather.com/v7/weather/7d";
    public static final String AQI_URL="https://devapi.qweather.com/v7/air/5d";
    public static final String SUGGEST_URL="https://devapi.qweather.com/v7/indices/1d";
    public static final String KEY="48eded087f314b1ea7e68b69f6c121a9";
    private String location="101210305";
    private  String type="1,3,8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.include1.btnInclude.setOnClickListener(v->{
            Toast.makeText(this, "Haha", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        requestNet();
    }

    private void requestNet() {

            String url1 = FORECAST_URL + "?" + "location=" + location + "&key=" + KEY;
            HttpUtil.sendOkHttpRequest(url1, new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String result = response.body().string();
                    Forecast forecast = gson.fromJson(result, Forecast.class);
                    Log.d("TAG234", result);

                    Log.d("TAG234", forecast.toString());

                }
            });
            String url2 = AQI_URL + "?" + "location=" + location + "&key=" + KEY;
            HttpUtil.sendOkHttpRequest(url2, new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String result = response.body().string();
                    AQI aqi = gson.fromJson(result, AQI.class);

                    Log.d("TAG23456", result);

                    Log.d("TAG23456", aqi.toString());
                }
            });
            String url3 = SUGGEST_URL + "?" + "location=" + location + "&key=" + KEY + "&type=" + type;
            HttpUtil.sendOkHttpRequest(url3, new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String result = response.body().string();
                    Suggest suggest = gson.fromJson(result, Suggest.class);

                    Log.d("TAG2345666", result);

                    Log.d("TAG2345666", suggest.toString());
                }
            });

    }
}