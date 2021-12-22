package com.example.earthquakereport;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<ArrayList<EarthQuakeModel>> {

    private static final String LOG_TAG = MainActivity.class.getName();
    private EarthQuakeAdapter mAdapter;
    private TextView emptyStateTextview;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View loadingProgresBar;


            private static final String USGS_REQUEST_URL3 =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=3&limit=100";
    private static final String USGS_REQUEST_URL2 ="https://earthquake.usgs.gov/fdsnws/event/1/query";
    private static final String USGS_REQUEST_URL ="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson";
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


        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_to_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getAnEarthquakeDataSwipe();
                Log.i(LOG_TAG, "testing : screen refresh called");
            }
        });

        // get your data at the end of the application running.
        getAnEarthquakeDataSwipe();

//        EarthQuakeAsync task = new EarthQuakeAsync();
//        task.execute(USGS_REQUEST_URL);


    }

    private void getAnEarthquakeDataSwipe() {

        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
        //if there is a network connectivity, fetchEarthquakeData
        if (isConnected) {

            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();
            Log.i(LOG_TAG, "testing on initialeze loader manager");

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(EARTH_LOADER_ID, null, this);
        } else {
            // Otherwise, display error
            mAdapter.clear();
            loadingProgresBar = findViewById(R.id.progress_bar);
            loadingProgresBar.setVisibility(View.GONE);

            // if thrown to empty state display
//            loadingProgresBar = findViewById(R.id.progress_bar);
//            loadingProgresBar.setVisibility(View.VISIBLE);

            // Set empty state text to display "No earthquakes found."
            emptyStateTextview.setVisibility(View.VISIBLE);
            emptyStateTextview.setText(R.string.no_earthquake);
            Log.i(LOG_TAG, "testing empty state called");
        }

        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public Loader<ArrayList<EarthQuakeModel>> onCreateLoader(int id, Bundle bundle) {
        Log.i(LOG_TAG, "testing oncreateLoader Loader method");

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String minMagnitude = prefs.getString(
                getString(R.string.settings_min_magnitude_key),
                getString(R.string.settings_min_magnitude_default));

        String orderBy = prefs.getString(
                getString(R.string.settings_order_by_key),
                getString(R.string.settings_order_by_default));

        Uri baseUri = Uri.parse(USGS_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("format", "geojson");
        uriBuilder.appendQueryParameter("limit", "10");
        uriBuilder.appendQueryParameter("minmag", minMagnitude);
        uriBuilder.appendQueryParameter("orderBy", orderBy);

        return new EarthquakeLoader(this, uriBuilder.toString());


    }

    @Override
    public void onLoadFinished(Loader<ArrayList<EarthQuakeModel>> loader, ArrayList<EarthQuakeModel> data) {
        //loading progress_bar first visible on opening
        loadingProgresBar = findViewById(R.id.progress_bar);
        loadingProgresBar.setVisibility(View.GONE);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_setting) {
            Intent intentSetting = new Intent(this, SettingActivity.class);
            startActivity(intentSetting);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}