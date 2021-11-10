package com.example.earthquakereport;

public class EarthQuakeModel {

private String magnitude;
private String location;
private String date;

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public EarthQuakeModel(String magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }
}
