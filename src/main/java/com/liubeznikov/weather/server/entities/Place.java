package com.liubeznikov.weather.server.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Entity
@ToString(of = {"name", "lat", "lon"})
@EqualsAndHashCode(of = {"id"})
public class Place {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany( cascade = CascadeType.ALL)
    private Set<Weather> weatherSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    private Double lat;
    private Double lon;

    public Set<Weather> getWeatherSet() {
        return weatherSet;
    }

    public void setWeatherSet(Set<Weather> weatherSet) {
        this.weatherSet = weatherSet;
    }


}
