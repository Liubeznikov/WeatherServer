package com.liubeznikov.weather.server;

import com.liubeznikov.weather.server.entities.Place;
import com.liubeznikov.weather.server.entities.builder.PlaceBuilder;
import com.liubeznikov.weather.server.repository.PlaceRepo;
import com.liubeznikov.weather.server.repository.WeatherRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
public class DataExample {

    @Autowired
    PlaceRepo placeRepo;
    @Autowired
    WeatherRepo weatherRepo;

    @Test
    public void setTestDataPlace(){
        PlaceBuilder placeBuilder = new PlaceBuilder();
        Place msk = placeBuilder.reset().setLatitude(37.61).setLontitude(55.75).setName("Moscow").result();
        placeRepo.save(msk);
        Place spb = placeBuilder.reset().setLatitude(30.37).setLontitude(60.00).setName("St.Petersburg").result();
        placeRepo.save(spb);
        Place murmansk = placeBuilder.reset().setLatitude(33.07).setLontitude(69.00).setName("Murmansk").result();
        placeRepo.save(murmansk);
        Place vor = placeBuilder.reset().setLatitude(39.21).setLontitude(51.66).setName("Voronezh").result();
        placeRepo.save(vor);
        Place krasnodar = placeBuilder.reset().setLatitude(39.00).setLontitude(45.00).setName("Krasnodar").result();
        placeRepo.save(krasnodar);
        Place sochi = placeBuilder.reset().setLatitude(39.74).setLontitude(43.58).setName("Sochi").result();
        placeRepo.save(sochi);

    }



    @Test
    public void deleteAllData(){
        weatherRepo.deleteAll();
        placeRepo.deleteAll();
    }
}
