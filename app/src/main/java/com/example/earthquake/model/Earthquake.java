package com.example.earthquake.model;

import com.google.gson.annotations.SerializedName;

public class Earthquake {
    @SerializedName("mag")
    private double magnitude;
    @SerializedName("place")
    private String location;
    @SerializedName("time")
    private long time;
    @SerializedName("url")
    private String url;

    public Earthquake(double mag, String location, int time, String url) {
        this.magnitude = mag;
        this.location = location;
        this.time = time;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double mag) {
        this.magnitude = mag;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
