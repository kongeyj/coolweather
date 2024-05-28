package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BingPic {

    /**
     * code
     */
    @SerializedName("code")
    private Integer code;
    /**
     * data
     */
    @SerializedName("data")
    private DataDTO data;
    /**
     * error
     */
    @SerializedName("error")
    private Object error;
    /**
     * updateTime
     */
    @SerializedName("updateTime")
    private Long updateTime;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public static class DataDTO {
        /**
         * id
         */
        @SerializedName("id")
        private Integer id;
        /**
         * time
         */
        @SerializedName("time")
        private String time;
        /**
         * title
         */
        @SerializedName("title")
        private String title;
        /**
         * url
         */
        @SerializedName("url")
        private String url;
        /**
         * urlbase
         */
        @SerializedName("urlbase")
        private String urlbase;
        /**
         * copyright
         */
        @SerializedName("copyright")
        private String copyright;
        /**
         * copyrightlink
         */
        @SerializedName("copyrightlink")
        private String copyrightlink;
        /**
         * urls
         */
        @SerializedName("urls")
        private List<String> urls;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlbase() {
            return urlbase;
        }

        public void setUrlbase(String urlbase) {
            this.urlbase = urlbase;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCopyrightlink() {
            return copyrightlink;
        }

        public void setCopyrightlink(String copyrightlink) {
            this.copyrightlink = copyrightlink;
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }
    }
}
