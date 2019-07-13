package com.liubeznikov.weather.server.httpRequest.Interfaces;

import com.liubeznikov.weather.server.entities.Weather;

public interface WeatherParser {

    public Weather parseWeather(String stringData);
}
