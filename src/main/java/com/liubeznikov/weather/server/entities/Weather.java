package com.liubeznikov.weather.server.entities;


import lombok.EqualsAndHashCode;

import lombok.ToString;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "WeatherData")
@ToString(of = {"place", "tempC","wxDesc","windspdMs", "winddirCompass","winddirDeg" ,"source","date"})
@EqualsAndHashCode(of = {"id"})
public class Weather {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn
    @NotNull
    private Place place;
    private Integer humidPct;
    private String wxDesc;
    private Double tempC;
    private Double windspdMs;
    private String winddirCompass;
    private Integer winddirDeg;
    private String source;
    private Date date;

    public Integer getHumidPct() {
        return humidPct;
    }

    public void setHumidPct(Integer humidPct) {
        this.humidPct = humidPct;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWxDesc() {
        return wxDesc;
    }

    public void setWxDesc(String wxDesc) {
        this.wxDesc = wxDesc;
    }

    public Double getTempC() {
        return tempC;
    }

    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    public Double getWindspdMs() {
        return windspdMs;
    }

    public void setWindspdMs(Double windspdMs) {
        this.windspdMs = windspdMs;
    }

    public String getWinddirCompass() {
        return winddirCompass;
    }

    public void setWinddirCompass(String winddirCompass) {
        this.winddirCompass = winddirCompass;
    }

    public Integer getWinddirDeg() {
        return winddirDeg;
    }

    public void setWinddirDeg(Integer winddirDeg) {
        this.winddirDeg = winddirDeg;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
