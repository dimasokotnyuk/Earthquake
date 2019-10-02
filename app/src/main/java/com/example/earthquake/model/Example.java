package com.example.earthquake.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("features")
    private List<Feature> features = null;

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
