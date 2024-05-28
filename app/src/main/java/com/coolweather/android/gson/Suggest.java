package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Suggest {

    /**
     * code
     */
    @SerializedName("code")
    private String code;
    /**
     * updateTime
     */
    @SerializedName("updateTime")
    private String updateTime;
    /**
     * fxLink
     */
    @SerializedName("fxLink")
    private String fxLink;
    /**
     * daily
     */
    @SerializedName("daily")
    private List<DailyDTO> daily;
    /**
     * refer
     */
    @SerializedName("refer")
    private ReferDTO refer;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFxLink() {
        return fxLink;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }

    public List<DailyDTO> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyDTO> daily) {
        this.daily = daily;
    }

    public ReferDTO getRefer() {
        return refer;
    }

    public void setRefer(ReferDTO refer) {
        this.refer = refer;
    }

    public static class ReferDTO {
        /**
         * sources
         */
        @SerializedName("sources")
        private List<String> sources;
        /**
         * license
         */
        @SerializedName("license")
        private List<String> license;

        public List<String> getSources() {
            return sources;
        }

        public void setSources(List<String> sources) {
            this.sources = sources;
        }

        public List<String> getLicense() {
            return license;
        }

        public void setLicense(List<String> license) {
            this.license = license;
        }
    }

    public static class DailyDTO {
        /**
         * date
         */
        @SerializedName("date")
        private String date;
        /**
         * type
         */
        @SerializedName("type")
        private String type;
        /**
         * name
         */
        @SerializedName("name")
        private String name;
        /**
         * level
         */
        @SerializedName("level")
        private String level;
        /**
         * category
         */
        @SerializedName("category")
        private String category;
        /**
         * text
         */
        @SerializedName("text")
        private String text;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
