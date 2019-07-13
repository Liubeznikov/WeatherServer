package com.liubeznikov.weather.server.httpRequest.WeatherUnlocked;

public class WeatherUnlockedUrl {
    private String appId;
    private String key;
    private Double lon;
    private Double lat;

    public WeatherUnlockedUrl setAppId(String appId){
        this.appId = appId;
        return this;
    }

    public WeatherUnlockedUrl setKey(String key){
        this.key = key;
        return this;
    }

    public WeatherUnlockedUrl setLon(Double lon){
        this.lon  = lon;
        return this;
    }

    public WeatherUnlockedUrl setLat(Double lat){
        this.lat = lat;
        return this;
    }

    public WeatherUnlockedUrl(String appId, String key, Double lon, Double lat){
        this.appId = appId;
        this.key = key;
        this.lon = lon;
        this.lat = lat;
    }

    public WeatherUnlockedUrl(){}

    @Override
    public String toString() {
        if (appId == null || key == null ||lat == null || lon == null) {
            throw new NullPointerException("Set all parameters");
        }
        return "http://api.weatherunlocked.com/api/current/" + lon.toString() +","+ lat.toString() +"?app_id=" + appId + "&app_key=" + key;
    }
}
