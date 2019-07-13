package com.liubeznikov.weather.server;

import com.liubeznikov.weather.server.entities.Place;
import com.liubeznikov.weather.server.httpRequest.WeatherUnlocked.WeatherUnlockedRequest;
import com.liubeznikov.weather.server.httpRequest.WeatherUnlocked.WeatherUnlockedUrl;
import com.liubeznikov.weather.server.repository.PlaceRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServerApplication.class})
public class HttpReqestTest {

    @Autowired
    PlaceRepo placeRepo;
    @Test
    public void sendGet() throws Exception {

        String url = "http://api.weatherunlocked.com/api/current/60.00,34.38?app_id=9e7e278b&app_key=86e0ca800981ffe10ae7ffaf524ccc0f";



        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    @Test
    public void unlockedWeatherURlCreateTest(){
        WeatherUnlockedUrl urlBuild = new WeatherUnlockedUrl();
        String url = urlBuild.setAppId(ServerSettings.weatherUnlockedAppId).setKey(ServerSettings.WeatherUnlockedKey).setLon(60.00).setLat(30.00).toString();
        WeatherUnlockedUrl urlConstructor = new WeatherUnlockedUrl(ServerSettings.weatherUnlockedAppId,ServerSettings.WeatherUnlockedKey,60.00,30.00);
        String url2 = urlConstructor.toString();
        System.out.println(url);
        Assert.assertEquals(url,url2);

    }

    @Test(expected = NullPointerException.class)
    public void badUrlCreation(){
        WeatherUnlockedUrl urlBuild = new WeatherUnlockedUrl();
        String url = urlBuild.setAppId(ServerSettings.weatherUnlockedAppId).setKey(ServerSettings.WeatherUnlockedKey).setLat(30.00).toString();
    }

    @Test
    public void getWeatherForAllPlaces() {
        WeatherUnlockedUrl urlBuild = new WeatherUnlockedUrl();
        List<Place> list = placeRepo.findAll();
        for (Place p : list) {
            String url = urlBuild.setAppId(ServerSettings.weatherUnlockedAppId).setKey(ServerSettings.WeatherUnlockedKey).setLon(p.getLon()).setLat(p.getLat()).toString();
            WeatherUnlockedRequest weatherUnlockedRequest = new WeatherUnlockedRequest();
            System.out.println(weatherUnlockedRequest.askWeather(url));
        }
    }

    @Test
    public void weatherUnlockedParse(){
        String data = "{\"lat\":55.65,\"lon\":37.27,\"alt_m\":203.0,\"alt_ft\":666.01,\"wx_desc\":\"Partly cloudy\",\"wx_code\":1,\"wx_icon\":\"PartlyCloudyDay." +
                "gif\",\"temp_c\":17.0,\"temp_f\":62.6,\"feelslike_c\":16.56,\"feelslike_f\":61.8,\"humid_pct\":52.0,\"windspd_mph\":9.32," +
                "\"windspd_kmh\":15.0,\"windspd_kts\":8.1,\"windspd_ms\":4.17,\"winddir_deg\":190.0,\"winddir_compass\":\"S\"," +
                "\"cloudtotal_pct\":50.0,\"vis_km\":10.0,\"vis_mi\":6.21,\"vis_desc\":null,\"slp_mb\":1005.1,\"slp_in\":29.76,\"dewpoint_c\":7.1,\"dewpoint_f\":44.79}";
    }


}
