package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<EarthQuakeModel> earthQuakes = new ArrayList<>();
        earthQuakes.add("San Franscisco");
        earthQuakes.add("London");
        earthQuakes.add("Tokyo");
        earthQuakes.add("Mexico City");
        earthQuakes.add("Moscow");
        earthQuakes.add("Rio De Jeniero");
        earthQuakes.add("Paris");

        // Find a reference to the {@link ListView} in the layout

        ArrayList<EarthQuakeModel> arraylistQuake = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.list);


        // Create a new {@link ArrayAdapter} of earthquakes
        EarthQuakeAdapter adapter = new EarthQuakeAdapter(this, earthQuakes);

        // Set the adapter on the {@link ListView}
        listView.setAdapter(adapter);
        // so the list can be populated in the user interface



    }
}