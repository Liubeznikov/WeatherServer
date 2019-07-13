package com.liubeznikov.weather.server.entities.builder;

import com.liubeznikov.weather.server.entities.Place;
import com.liubeznikov.weather.server.entities.Weather;

import java.util.Date;

public class WeatherBuilder {
    private Weather weather;
    public WeatherBuilder reset(){
        weather = new Weather();
        return this;
    }

    public Weather result(){
        return weather;
    }

    public WeatherBuilder setWxDesc(String wxDesc){
        weather.setWxDesc(wxDesc);
        return this;
    }

    public WeatherBuilder setTempC (Double tempC){
        weather.setTempC(tempC);
        return this;
    }

    public WeatherBuilder setWindspdMs (Double windspdMs){
        weather.setWindspdMs(windspdMs);
        return this;
    }

    public WeatherBuilder setPlace (Place place){
        weather.setPlace(place);
        return this;
    }

    public WeatherBuilder setWinddirCompass (String winddirCompass){
        weather.setWinddirCompass(winddirCompass);
        return this;
    }

    public WeatherBuilder setSource (String source){
        weather.setSource(source);
        return this;
    }

    public WeatherBuilder setWinddirDeg(Integer winddirDeg){
        weather.setWinddirDeg(winddirDeg);
        return this;
    }

    public WeatherBuilder setDate(Date date){
        weather.setDate(date);
        return this;
    }

    public WeatherBuilder setHumidPct(Integer humidPct){
        weather.setHumidPct(humidPct);
        return this;
    }


}
