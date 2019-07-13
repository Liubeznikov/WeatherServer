package com.liubeznikov.weather.server.repository;

import com.liubeznikov.weather.server.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<Weather,Long> {
}
