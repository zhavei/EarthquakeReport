package com.example.earthquakereport;

public class EarthQuakeModel {

private String magnitude;
private String location;
private String date;
private Long longTime;

    public String getMagnitude() {
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

    public EarthQuakeModel(String magnitude, String location, String date, Long longTime) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.longTime = longTime;
    }

}
