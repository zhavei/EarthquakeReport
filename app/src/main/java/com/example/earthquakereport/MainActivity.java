package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        ArrayList<String> earthQuakes = new ArrayList<>();
        earthQuakes.add("San Franscisco");
        earthQuakes.add("London");
        earthQuakes.add("Tokyo");
        earthQuakes.add("Mexico City");
        earthQuakes.add("Moscow");
        earthQuakes.add("Rio De Jeniero");
        earthQuakes.add("Paris");

        // Find a reference to the {@link ListView} in the layout
        ListView earthQuaekeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, earthQuakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface

        earthQuaekeListView.setAdapter(adapter);

    }
}