package com.example.earthquakereport;

public class EarthQuakeModel {

    private double mMagnitude;
    private String mLocation;
    private long mLongTime;
    private String mUrl;

    public EarthQuakeModel(double magnitude, String location, long longTime, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mLongTime = longTime;
        mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public long getLongTime() {
        return mLongTime;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getUrl() {
        return mUrl;
    }

}
