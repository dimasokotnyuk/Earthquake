package com.example.earthquake.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.earthquake.model.Earthquake;

import java.util.List;

public class Utils extends AndroidViewModel {
    
    private Mu<List<Earthquake>> earthquakes;

    public Utils(@NonNull Application application) {
        super(application);
    }
}
