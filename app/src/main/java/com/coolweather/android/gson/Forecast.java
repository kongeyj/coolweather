package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {

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
         * fxDate
         */
        @SerializedName("fxDate")
        private String fxDate;
        /**
         * sunrise
         */
        @SerializedName("sunrise")
        private String sunrise;
        /**
         * sunset
         */
        @SerializedName("sunset")
        private String sunset;
        /**
         * moonrise
         */
        @SerializedName("moonrise")
        private String moonrise;
        /**
         * moonset
         */
        @SerializedName("moonset")
        private String moonset;
        /**
         * moonPhase
         */
        @SerializedName("moonPhase")
        private String moonPhase;
        /**
         * moonPhaseIcon
         */
        @SerializedName("moonPhaseIcon")
        private String moonPhaseIcon;
        /**
         * tempMax
         */
        @SerializedName("tempMax")
        private String tempMax;
        /**
         * tempMin
         */
        @SerializedName("tempMin")
        private String tempMin;
        /**
         * iconDay
         */
        @SerializedName("iconDay")
        private String iconDay;
        /**
         * textDay
         */
        @SerializedName("textDay")
        private String textDay;
        /**
         * iconNight
         */
        @SerializedName("iconNight")
        private String iconNight;
        /**
         * textNight
         */
        @SerializedName("textNight")
        private String textNight;
        /**
         * wind360Day
         */
        @SerializedName("wind360Day")
        private String wind360Day;
        /**
         * windDirDay
         */
        @SerializedName("windDirDay")
        private String windDirDay;
        /**
         * windScaleDay
         */
        @SerializedName("windScaleDay")
        private String windScaleDay;
        /**
         * windSpeedDay
         */
        @SerializedName("windSpeedDay")
        private String windSpeedDay;
        /**
         * wind360Night
         */
        @SerializedName("wind360Night")
        private String wind360Night;
        /**
         * windDirNight
         */
        @SerializedName("windDirNight")
        private String windDirNight;
        /**
         * windScaleNight
         */
        @SerializedName("windScaleNight")
        private String windScaleNight;
        /**
         * windSpeedNight
         */
        @SerializedName("windSpeedNight")
        private String windSpeedNight;
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
         * uvIndex
         */
        @SerializedName("uvIndex")
        private String uvIndex;

        public String getFxDate() {
            return fxDate;
        }

        public void setFxDate(String fxDate) {
            this.fxDate = fxDate;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getMoonrise() {
            return moonrise;
        }

        public void setMoonrise(String moonrise) {
            this.moonrise = moonrise;
        }

        public String getMoonset() {
            return moonset;
        }

        public void setMoonset(String moonset) {
            this.moonset = moonset;
        }

        public String getMoonPhase() {
            return moonPhase;
        }

        public void setMoonPhase(String moonPhase) {
            this.moonPhase = moonPhase;
        }

        public String getMoonPhaseIcon() {
            return moonPhaseIcon;
        }

        public void setMoonPhaseIcon(String moonPhaseIcon) {
            this.moonPhaseIcon = moonPhaseIcon;
        }

        public String getTempMax() {
            return tempMax;
        }

        public void setTempMax(String tempMax) {
            this.tempMax = tempMax;
        }

        public String getTempMin() {
            return tempMin;
        }

        public void setTempMin(String tempMin) {
            this.tempMin = tempMin;
        }

        public String getIconDay() {
            return iconDay;
        }

        public void setIconDay(String iconDay) {
            this.iconDay = iconDay;
        }

        public String getTextDay() {
            return textDay;
        }

        public void setTextDay(String textDay) {
            this.textDay = textDay;
        }

        public String getIconNight() {
            return iconNight;
        }

        public void setIconNight(String iconNight) {
            this.iconNight = iconNight;
        }

        public String getTextNight() {
            return textNight;
        }

        public void setTextNight(String textNight) {
            this.textNight = textNight;
        }

        public String getWind360Day() {
            return wind360Day;
        }

        public void setWind360Day(String wind360Day) {
            this.wind360Day = wind360Day;
        }

        public String getWindDirDay() {
            return windDirDay;
        }

        public void setWindDirDay(String windDirDay) {
            this.windDirDay = windDirDay;
        }

        public String getWindScaleDay() {
            return windScaleDay;
        }

        public void setWindScaleDay(String windScaleDay) {
            this.windScaleDay = windScaleDay;
        }

        public String getWindSpeedDay() {
            return windSpeedDay;
        }

        public void setWindSpeedDay(String windSpeedDay) {
            this.windSpeedDay = windSpeedDay;
        }

        public String getWind360Night() {
            return wind360Night;
        }

        public void setWind360Night(String wind360Night) {
            this.wind360Night = wind360Night;
        }

        public String getWindDirNight() {
            return windDirNight;
        }

        public void setWindDirNight(String windDirNight) {
            this.windDirNight = windDirNight;
        }

        public String getWindScaleNight() {
            return windScaleNight;
        }

        public void setWindScaleNight(String windScaleNight) {
            this.windScaleNight = windScaleNight;
        }

        public String getWindSpeedNight() {
            return windSpeedNight;
        }

        public void setWindSpeedNight(String windSpeedNight) {
            this.windSpeedNight = windSpeedNight;
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

        public String getUvIndex() {
            return uvIndex;
        }

        public void setUvIndex(String uvIndex) {
            this.uvIndex = uvIndex;
        }
    }
}
