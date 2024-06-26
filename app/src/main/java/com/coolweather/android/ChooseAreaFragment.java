package com.coolweather.android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.coolweather.android.databinding.ChooseAreaBinding;
import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.util.Utility;

import org.jetbrains.annotations.NotNull;
import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ChooseAreaFragment extends Fragment {

    /** 根据级别不同，显示不同列表数据，如果级别为0，则显示省份列表 **/
    public static final int LEVEL_PROVINCE = 0;
    public static final int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;

    /** 进度对话框 **/
    private ProgressDialog progressDialog;



    private ArrayAdapter<String> adapter; //列表组件所需的适配器组件

    private List<String> dataList = new ArrayList<>(); //列表数据

    /**
     * 省列表
     */
    private List<Province> provinceList;

    /**
     * 市列表
     */
    private List<City> cityList;

    /**
     * 县列表
     */
    private List<County> countyList;

    /**
     * 选中的省份
     */
    private Province selectedProvince;

    /**
     * 选中的城市
     */
    private City selectedCity;

    /**
     * 当前选中的级别
     */
    private int currentLevel;

    ChooseAreaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding=ChooseAreaBinding.inflate(inflater,container,false);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);
        binding.listView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.listView.setOnItemClickListener((adapterView, view, position, id) -> {
            if(currentLevel==LEVEL_PROVINCE){
                selectedProvince=provinceList.get(position);
                queryCities();
            }else if(currentLevel==LEVEL_CITY){
                selectedCity=cityList.get(position);
                queryCounties();
            }else if (currentLevel == LEVEL_COUNTY) {

                String weatherId = countyList.get(position).getWeatherId();
                Intent intent = new Intent(getActivity(), WeatherActivity.
                        class);
                intent.putExtra("current_province",selectedProvince.getProvinceName());
                intent.putExtra("current_city",selectedCity.getCityName());
                intent.putExtra("current_county",countyList.get(position).getCountyName());
                intent.putExtra("weather_id", weatherId);
                startActivity(intent);
                getActivity().finish();
            }



        });
        binding.backButton.setOnClickListener(v->{
            if(currentLevel==LEVEL_COUNTY){
                queryCities();
            }else if(currentLevel==LEVEL_CITY){
                queryProvinces();
            }
        });
        queryProvinces();
    }

    /**
     * 查询全国所有的省，优先从数据库查询，如果没有查询到再去服务器去查询
     */
    private void queryProvinces() {
        binding.titleText.setText("中国");
        binding.backButton.setVisibility(View.GONE);

        provinceList= LitePal.findAll(Province.class);
        if(provinceList.size()>0){
            dataList.clear();
            for(Province province:provinceList){
                dataList.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            binding.listView.setSelection(0);
            currentLevel=LEVEL_PROVINCE;
        }else{
            String address="http://guolin.tech/api/china";
            queryFromServer(address,"province");
        }

    }

    /**
     * 根据传入的地址和类型从服务器上查询省市县数据
     * @param address  URL地址
     * @param type   类型
     */
    private void queryFromServer(String address, String type) {
        showProgressDialog();
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
       //通过runOnUiThread()方法回到主线程处理逻辑
                getActivity().runOnUiThread(()->{
                    Toast.makeText(getContext(), "加载失败！", Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                  String responseText=response.body().string();
                  boolean result=false;
                  if("province".equals(type)){
                      result= Utility.handleProvinceResponse(responseText);
                  }else if("city".equals(type)){
                      result=Utility.handleCityResponse(responseText,selectedProvince.getId());
                  }else if("county".equals(type)){
                      result=Utility.handleCountyResponse(responseText,selectedCity.getId());
                  }
                  if(result){
                      getActivity().runOnUiThread(()->{
                          closeProgressDialog();
                          if("province".equals(type)){
                              queryProvinces();
                          }else if("city".equals(type)){
                              queryCities();
                          }else if("county".equals(type)){
                              queryCounties();
                          }
                      });
                  }
            }
        });
    }

    /**
     * 关闭进度对话框
     */
    private void closeProgressDialog() {
        if(progressDialog!=null){
            progressDialog.dismiss();
        }
    }

    /**
     * 显示晕度对话框
     */
    private void showProgressDialog() {
        if(progressDialog==null){
            progressDialog=new ProgressDialog(getActivity());
            progressDialog.setMessage("正在加载...");
            progressDialog.setCancelable(false);
        }
        progressDialog.show();

    }


    /**
     * 查询选中省内所有的市，优先从数据库查询，如果没有查询到再去服务器上查询
     */
    private void queryCities() {
        binding.titleText.setText(selectedProvince.getProvinceName());
        binding.backButton.setVisibility(View.VISIBLE);

        cityList=LitePal.where("provinceid=?",String.valueOf(selectedProvince.getId()))
                .find(City.class);
        if(cityList.size()>0){
            dataList.clear();
            for(City city:cityList){
                dataList.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            binding.listView.setSelection(0);
            currentLevel=LEVEL_CITY;
        }else{
            int provinceCode=selectedProvince.getProvinceCode();
            String address="http://guolin.tech/api/china/"+provinceCode;
            queryFromServer(address,"city");
        }
    }

    /**
     * 查询选中市内所有的县，优先从数据库查询，如果没有查询到再去服务器上查询
     */
    private void queryCounties() {
        binding.titleText.setText(selectedCity.getCityName());
        binding.backButton.setVisibility(View.VISIBLE);

        countyList=LitePal.where("cityid=?",String.valueOf(selectedCity.getId()))
                .find(County.class);
        if(countyList.size()>0){
            dataList.clear();
            for(County county:countyList){
                dataList.add(county.getCountyName());
            }
            adapter.notifyDataSetChanged();
            binding.listView.setSelection(0);
            currentLevel=LEVEL_COUNTY;
        }else{
            int provinceCode=selectedProvince.getProvinceCode();
            int cityCode=selectedCity.getCityCode();
            String address="http://guolin.tech/api/china/"+provinceCode+"/"+cityCode;
            queryFromServer(address,"county");
        }
    }


}
