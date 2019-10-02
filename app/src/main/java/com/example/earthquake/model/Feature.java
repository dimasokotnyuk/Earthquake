package com.example.earthquake.model;

import com.google.gson.annotations.SerializedName;

public class Feature {

    @SerializedName("properties")
    private Earthquake properties;

    public Earthquake getProperties() {
        return properties;
    }

    public void setProperties(Earthquake properties) {
        this.properties = properties;
    }
}
