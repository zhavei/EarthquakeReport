package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create a fake list of earthquake locations.
        ArrayList<EarthQuakeModel> earthQuakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthQuakeAdapter adapter = new EarthQuakeAdapter(this, earthQuakes);
        ListView listView = (ListView) findViewById(R.id.list);

        // Set the adapter on the {@link ListView}
        listView.setAdapter(adapter);
        // so the list can be populated in the user interface

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EarthQuakeModel earthQuakeModel = earthQuakes.get(position);
                Toast.makeText(MainActivity.this, "item click", Toast.LENGTH_SHORT).show();
            }
        });





    }
}