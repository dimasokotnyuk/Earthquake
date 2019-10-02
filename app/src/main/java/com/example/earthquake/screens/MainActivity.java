package com.example.earthquake.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.earthquake.adapters.EarthquakeAdapter;
import com.example.earthquake.model.Earthquake;
import com.example.earthquake.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewEarthquake;
    private EarthquakeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        recyclerViewEarthquake = findViewById(R.id.recyclerViewEarthquake);

        adapter = new EarthquakeAdapter(this);
        adapter.setEarthquakes(earthquakes);
        recyclerViewEarthquake.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewEarthquake.setAdapter(adapter);
        adapter.setOnEarthquakeClickListener(new EarthquakeAdapter.OnEarthquakeClickListener() {
            @Override
            public void onEarthquakeClickListener(int position) {
                Earthquake earthquake = adapter.getEarthquakes().get(position);
                Uri earthquakeUri = Uri.parse(earthquake.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(intent);
            }
        });
    }
}
