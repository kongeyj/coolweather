package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NowWeather {

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
     * now
     */
    @SerializedName("now")
    private NowDTO now;
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

    public NowDTO getNow() {
        return now;
    }

    public void setNow(NowDTO now) {
        this.now = now;
    }

    public ReferDTO getRefer() {
        return refer;
    }

    public void setRefer(ReferDTO refer) {
        this.refer = refer;
    }

    public static class NowDTO {
        /**
         * obsTime
         */
        @SerializedName("obsTime")
        private String obsTime;
        /**
         * temp
         */
        @SerializedName("temp")
        private String temp;
        /**
         * feelsLike
         */
        @SerializedName("feelsLike")
        private String feelsLike;
        /**
         * icon
         */
        @SerializedName("icon")
        private String icon;
        /**
         * text
         */
        @SerializedName("text")
        private String text;
        /**
         * wind360
         */
        @SerializedName("wind360")
        private String wind360;
        /**
         * windDir
         */
        @SerializedName("windDir")
        private String windDir;
        /**
         * windScale
         */
        @SerializedName("windScale")
        private String windScale;
        /**
         * windSpeed
         */
        @SerializedName("windSpeed")
        private String windSpeed;
        /**
         * humidity
         */
        @SerializedName("humidity")
        private String humidity;
        /**
         * precip
         */
        @SerializedName("precip")
        private String precip;
        /**
         * pressure
         */
        @SerializedName("pressure")
        private String pressure;
        /**
         * vis
         */
        @SerializedName("vis")
        private String vis;
        /**
         * cloud
         */
        @SerializedName("cloud")
        private String cloud;
        /**
         * dew
         */
        @SerializedName("dew")
        private String dew;

        public String getObsTime() {
            return obsTime;
        }

        public void setObsTime(String obsTime) {
            this.obsTime = obsTime;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(String feelsLike) {
            this.feelsLike = feelsLike;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getWind360() {
            return wind360;
        }

        public void setWind360(String wind360) {
            this.wind360 = wind360;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public String getWindScale() {
            return windScale;
        }

        public void setWindScale(String windScale) {
            this.windScale = windScale;
        }

        public String getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPrecip() {
            return precip;
        }

        public void setPrecip(String precip) {
            this.precip = precip;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public String getCloud() {
            return cloud;
        }

        public void setCloud(String cloud) {
            this.cloud = cloud;
        }

        public String getDew() {
            return dew;
        }

        public void setDew(String dew) {
            this.dew = dew;
        }
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
}
