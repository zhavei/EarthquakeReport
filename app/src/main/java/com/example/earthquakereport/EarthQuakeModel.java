package com.example.earthquakereport;

public class EarthQuakeModel {

private Double magnitude;
private String location;
private String date;
private Long longTime;
private String url;



    public Double getMagnitude() {
        return magnitude;
    }

    public Long getLongTime() {
        return longTime;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }


    public EarthQuakeModel(Double magnitude, String location, Long longTime, String url ) {
        this.magnitude = magnitude;
        this.location = location;
        this.longTime = longTime;
        this.url = url;
    }

}
