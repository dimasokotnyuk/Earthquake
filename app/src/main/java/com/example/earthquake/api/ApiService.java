package com.example.earthquake.api;

import com.example.earthquake.model.Feature;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    //@GET("query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10")
    @GET("query?")
    Observable<Feature> getEarthquake(@Query("format")String format, @Query("eventtype")String eventtype, @Query("orderby")String orderby, @Query("minmag") int minmag, @Query("limit")int limit);
}
