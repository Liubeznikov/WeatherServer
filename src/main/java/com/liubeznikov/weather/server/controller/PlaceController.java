package com.liubeznikov.weather.server.controller;

import com.liubeznikov.weather.server.entities.Place;
import com.liubeznikov.weather.server.repository.PlaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("place")
public class PlaceController {
    @Autowired
    PlaceRepo placeRepo;

    @GetMapping("allPlaces")
    public List<Place> getAllPlaces(){
        return placeRepo.findAll();
    }

    @PostMapping("postPlace")
    public Place postPlace (Place place){
        return placeRepo.save(place);
    }

}
