package com.example.earthquakereport;

public class EarthQuakeModel {

private double magnitude;
    private String location;
    private long longTime;
    private String url;


    public double getMagnitude() {
        return magnitude;
    }

    public long getLongTime() {
        return longTime;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }


    public EarthQuakeModel(double magnitude, String location, long longTime, String url ) {
        this.magnitude = magnitude;
        this.location = location;
        this.longTime = longTime;
        this.url = url;
    }

}
