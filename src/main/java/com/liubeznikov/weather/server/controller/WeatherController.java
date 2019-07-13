package com.liubeznikov.weather.server.controller;

import com.liubeznikov.weather.server.entities.Weather;
import com.liubeznikov.weather.server.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("weather")
public class WeatherController {
    @Autowired
    WeatherRepo weatherRepo;

    @GetMapping("/all")
    public List<Weather> getAllHistory(){
        return weatherRepo.findAll();
    }

    @PostMapping("/post")
    public Weather postWeather (Weather weather){
        return weatherRepo.save(weather);
    }



}
