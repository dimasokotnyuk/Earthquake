package com.example.earthquake.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static ApiFactory apiFactory;
    private static Retrofit retrofit;
    private static final String BASE_URL="https://earthquake.usgs.gov/fdsnws/event/1/";
    // query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=

    private ApiFactory(){
        retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static ApiFactory getInstance(){
        if(apiFactory==null){
            apiFactory= new ApiFactory();
        }
        return apiFactory;
    }


}
