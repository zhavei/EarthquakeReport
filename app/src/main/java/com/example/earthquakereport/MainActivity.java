package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<EarthQuakeModel> earthQuakes = QueryUtils.extractEarthquakes(USGS_REQUEST_URL);


        // Find a reference to the {@link ListView} in the layout

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthQuakeAdapter adapter = new EarthQuakeAdapter(this, earthQuakes);
        ListView listView = (ListView) findViewById(R.id.list_in_activity_main);


        // Set the adapter on the {@link ListView}
        listView.setAdapter(adapter);

        
        // so the list can be populated in the user interface
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                EarthQuakeModel earthQuakeModel = earthQuakes.get(position);
//                Toast.makeText(MainActivity.this, "item click", Toast.LENGTH_SHORT).show();
//                Uri earthQuakeUri = Uri.parse(earthQuakeModel.getUrl());
//
//                Intent webIntent = new Intent(Intent.ACTION_VIEW, earthQuakeUri);
//                startActivity(webIntent);
//
//            }
//        });

    }

    private class EarthQuakeAsync extends AsyncTask<String, Void, ArrayList<EarthQuakeModel>> {

        @Override
        protected ArrayList<EarthQuakeModel> doInBackground(String... urls) {
            if (urls.length < 1 || urls == null){
                return null;
            }

            ArrayList<EarthQuakeModel> earthQuakeModel = QueryUtils.fetchEarthquakeData(urls);
            return earthQuakeModel;
        }

        @Override
        protected void onPostExecute(ArrayList<EarthQuakeModel> result) {
            if (result = null){
                return;
            }
            updateUi(result);
        }
    }




}