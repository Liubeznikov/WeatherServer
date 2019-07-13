package com.liubeznikov.weather.server;


import com.liubeznikov.weather.server.entities.Place;
import com.liubeznikov.weather.server.entities.Weather;
import com.liubeznikov.weather.server.entities.builder.PlaceBuilder;
import com.liubeznikov.weather.server.entities.builder.WeatherBuilder;
import com.liubeznikov.weather.server.repository.PlaceRepo;
import com.liubeznikov.weather.server.repository.WeatherRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;
import org.xml.sax.SAXException;

import javax.persistence.RollbackException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
public class WeatherRepoTest {

    @Autowired
    WeatherRepo weatherRepo;

    @Autowired
    PlaceRepo placeRepo;

    @Test
    public void createWeather(){
        PlaceBuilder placeBuilder = new PlaceBuilder();
        Place place = placeBuilder.reset().setLatitude(37.60).setLontitude(55.75).setName("Moscow").result();
        Place placeFromDb = placeRepo.save(place);

        WeatherBuilder weatherBuilder = new WeatherBuilder();
        Date date = new Date();
        Weather weather = weatherBuilder.reset().setPlace(place).setSource("Kolya").setTempC(22.11).setWinddirCompass("W")
                .setWxDesc("Cloudly").setWinddirDeg(270).setWindspdMs(3.0).setDate(date).result();
        Weather weatherFromDb = weatherRepo.save(weather);

        System.out.println(place);
        System.out.println(placeFromDb);
        System.out.println(weather);
        System.out.println(weatherFromDb);


    }

    @Test(expected = TransactionSystemException.class)
    public void saveWeatherWithoutPlace(){

        WeatherBuilder weatherBuilder = new WeatherBuilder();
        Weather weather = weatherBuilder.reset().setSource("Kolya").setTempC(22.11).setWinddirCompass("W")
                .setWxDesc("Cloudly").setWinddirDeg(270).setWindspdMs(3.0).result();
        Weather weatherFromDb = weatherRepo.save(weather);

    }

    @Test
    public void DeleteTest(){

        PlaceBuilder placeBuilder = new PlaceBuilder();
        Place spb = placeBuilder.reset().setLatitude(37.60).setLontitude(55.75).setName("Moscow").result();
        placeRepo.save(spb);


        WeatherBuilder weatherBuilder = new WeatherBuilder();
        Weather weather = weatherBuilder.reset().setPlace(spb).setSource("Kolya").setTempC(22.11).setWinddirCompass("W")
                .setWxDesc("Cloudly").setWinddirDeg(270).setWindspdMs(3.0).result();
        weatherRepo.save(weather);
        weather = weatherBuilder.reset().setPlace(spb).setSource("Kolya").setTempC(22.11).setWinddirCompass("SW")
                .setWxDesc("Sun").setWinddirDeg(100).setWindspdMs(3.0).result();
        weatherRepo.save(weather);
        weatherRepo.deleteAll();

        placeRepo.delete(spb);

        List<Weather> weathers = weatherRepo.findAll();
        List<Place> places = placeRepo.findAll();
        Assert.assertEquals(weathers.size(), 0);
        Assert.assertEquals(places.size(), 0);

    }

}
