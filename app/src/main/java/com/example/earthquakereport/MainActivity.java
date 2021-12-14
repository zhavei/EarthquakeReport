package com.example.earthquakereport;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<ArrayList<EarthQuakeModel>> {

    private static final String LOG_TAG = MainActivity.class.getName();
    private EarthQuakeAdapter mAdapter;

    private TextView emptyStateTextview;

    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=3&limit=20";
    private static final int EARTH_LOADER_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ListView listView = (ListView) findViewById(R.id.list_in_activity_main);
        mAdapter = new EarthQuakeAdapter(this, new ArrayList<EarthQuakeModel>());

        // Set the adapter on the {@link ListView}
        listView.setAdapter(mAdapter);

        //creta empty state textview
        emptyStateTextview = (TextView) findViewById(R.id.emptyview_text);
        listView.setEmptyView(emptyStateTextview);

        LoaderManager loaderManager = getLoaderManager();
        Log.i(LOG_TAG, "testing on initialeze loader manager");
        loaderManager.initLoader(EARTH_LOADER_ID, null, this);

//        EarthQuakeAsync task = new EarthQuakeAsync();
//        task.execute(USGS_REQUEST_URL);


    }

    @Override
    public Loader<ArrayList<EarthQuakeModel>> onCreateLoader(int id, Bundle bundle) {
        Log.i(LOG_TAG, "testing oncreateLoader Loader method");

        return new EarthquakeLoader(this, USGS_REQUEST_URL);


    }

    @Override
    public void onLoadFinished(Loader<ArrayList<EarthQuakeModel>> loader, ArrayList<EarthQuakeModel> data) {
        //progress bar
        View loadingProgresBar = findViewById(R.id.progress_bar);
        loadingProgresBar.setVisibility(View.GONE);

        // Set empty state text to display "No earthquakes found."
        emptyStateTextview.setText(R.string.no_earthquake);
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        }

        Log.i(LOG_TAG, "testing onloadFinish update the UI Succefully");

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<EarthQuakeModel>> loader) {
        mAdapter.clear();
        Log.i(LOG_TAG, "testing resetLoader");
    }


//    private class EarthQuakeAsync extends AsyncTask<String, Void, ArrayList<EarthQuakeModel>> {
//
//        @Override
//        protected ArrayList<EarthQuakeModel> doInBackground(String... urls) {
//            if (urls.length < 1 || urls[0] == null) {
//                return null;
//            }
//
//            ArrayList<EarthQuakeModel> earthQuakeModelResult = QueryUtils.fetchEarthquakeData(urls[0]);
//            return earthQuakeModelResult;
//        }
//
//        @Override
//        protected void onPostExecute(ArrayList<EarthQuakeModel> result) {
//            mAdapter.clear();
//
//            if (result == null) {
//                return;
//            } else if (result != null && !result.isEmpty()) {
//                mAdapter.addAll(result);
//            }
//
//        }
//    }


}