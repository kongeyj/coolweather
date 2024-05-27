package com.coolweather.android.db;

import org.litepal.crud.LitePalSupport;


public class Province extends LitePalSupport {

    private int id;

    private String provinceName;//省份名称  浙江

    private int provinceCode; //省份编码    17

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
