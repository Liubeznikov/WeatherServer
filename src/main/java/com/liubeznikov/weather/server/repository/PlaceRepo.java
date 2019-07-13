package com.liubeznikov.weather.server.repository;

import com.liubeznikov.weather.server.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepo extends JpaRepository<Place,Long> {
}
