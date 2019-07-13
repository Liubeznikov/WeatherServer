package com.liubeznikov.weather.server;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.liubeznikov.weather.server.entities.Place;
import com.liubeznikov.weather.server.entities.Weather;
import com.liubeznikov.weather.server.entities.builder.PlaceBuilder;
import com.liubeznikov.weather.server.entities.builder.WeatherBuilder;
import org.junit.Assert;
import org.junit.Test;

public class BuilderTest {

    @Test
    public void createPlace(){
        Place place = new Place();
        place.setName("Moscow");
        place.setLat(35.35);
        place.setLon(55.55);

        PlaceBuilder placeBuilder = new PlaceBuilder();
        Place builtPlace = placeBuilder.reset().setLatitude(35.35).setLontitude(55.55).setName("Moscow").result();
        Assert.assertEquals(place.getName(), builtPlace.getName());
        Assert.assertEquals(place.getLat(), builtPlace.getLat());
        Assert.assertEquals(place.getLon(), builtPlace.getLon());


    }
    @Test
    public void buildTwoObjectsPlace(){
        Place place = new Place();
        place.setName("Moscow");
        place.setLat(37.60);
        place.setLon(55.75);

        PlaceBuilder placeBuilder = new PlaceBuilder();

        Place builtPlace = placeBuilder.reset().setLatitude(37.60).setLontitude(55.75).setName("Moscow").result();

        Place builtPlace2 = placeBuilder.reset().setLatitude(55.75).setLontitude(60.00).setName("St.Petersburg").result();

        Assert.assertEquals(place.getName(), builtPlace.getName());
        Assert.assertEquals(place.getLat(), builtPlace.getLat());
        Assert.assertEquals(place.getLon(), builtPlace.getLon());
    }

    @Test public void CreateWeather(){

        PlaceBuilder placeBuilder = new PlaceBuilder();
        Place place = placeBuilder.reset().setLatitude(37.60).setLontitude(55.75).setName("Moscow").result();
        WeatherBuilder weatherBuilder = new WeatherBuilder();
        Weather builtWeather = weatherBuilder.reset().setPlace(place).setSource("Kolya").setTempC(22.11).setWinddirCompass("W")
                .setWxDesc("Cloudly").setWinddirDeg(270).setWindspdMs(3.0).result();

        Weather weather = new Weather();
        weather.setPlace(place);
        weather.setSource("Kolya");
        weather.setTempC(22.11);
        weather.setWinddirCompass("W");
        weather.setWxDesc("Cloudly");
        weather.setWinddirDeg(270);
        weather.setWindspdMs(3.0);

        Assert.assertEquals(weather.getTempC(), builtWeather.getTempC());
        Assert.assertEquals(weather.getPlace(), builtWeather.getPlace());
        Assert.assertEquals(weather.getSource(), builtWeather.getSource());
        Assert.assertEquals(weather.getWinddirCompass(), builtWeather.getWinddirCompass());
        Assert.assertEquals(weather.getWinddirDeg(), builtWeather.getWinddirDeg());
        Assert.assertEquals(weather.getWindspdMs(), builtWeather.getWindspdMs());
        Assert.assertEquals(weather.getWxDesc(), builtWeather.getWxDesc());
    }

}
