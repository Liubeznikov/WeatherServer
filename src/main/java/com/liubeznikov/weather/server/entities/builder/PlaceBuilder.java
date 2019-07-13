package com.liubeznikov.weather.server.entities.builder;

import com.liubeznikov.weather.server.entities.Place;

public class PlaceBuilder {
    private Place place;

    public PlaceBuilder reset(){
        place = new Place();
        return this;
    }

    public Place result(){
        return place;
    }

    public PlaceBuilder setLontitude(Double lon){
        place.setLon(lon);
        return this;
    }

    public PlaceBuilder setLatitude(Double lat){
        place.setLat(lat);
        return this;
    }

    public PlaceBuilder setName(String name){
        place.setName(name);
        return this;
    }

}
