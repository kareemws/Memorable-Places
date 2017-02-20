package com.example.kareemwaleed.memorableplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    static ArrayList<String> placesList;
    private ListView placesListView;
    static ArrayAdapter arrayAdapter;
    static ArrayList<LatLng> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepare();
    }


    private void prepare()
    {
        placesListView = (ListView) findViewById(R.id.placesListView);
        if(placesList == null)
        {
            placesList = new ArrayList<>();
            placesList.add("Add new place ...");
            locations = new ArrayList<>();
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, placesList);
        }
        placesListView.setAdapter(arrayAdapter);
        placesListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("Position", position);
        startActivity(intent);
    }
}
