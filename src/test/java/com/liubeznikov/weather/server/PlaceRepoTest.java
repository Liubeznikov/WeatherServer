package com.liubeznikov.weather.server;


import com.liubeznikov.weather.server.entities.Place;
import com.liubeznikov.weather.server.repository.PlaceRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PlaceRepoTest {
    @Autowired
    PlaceRepo placeRepo;
    @Test
    public void savePlaceInDb(){
        Place place = new Place();
        place.setLat(60.00);
        place.setLon(34.11);
        place.setName("St.Petersburg");
        Place placeFromDb;
        placeFromDb = placeRepo.save(place);

        Assert.assertEquals(place.getName(), placeFromDb.getName());
        Assert.assertEquals(place.getLon(), placeFromDb.getLon());
        Assert.assertEquals(place.getLat(), placeFromDb.getLat());
    }

}
