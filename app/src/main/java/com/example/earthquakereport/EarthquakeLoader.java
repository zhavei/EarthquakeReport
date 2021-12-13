package com.example.earthquakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<EarthQuakeModel>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "testing onstartLoading EarthquakeLoader Class");
        forceLoad();
    }

    @Override
    public ArrayList<EarthQuakeModel> loadInBackground() {
        Log.i(LOG_TAG, "testing Loading In Backgroound Succesfull");
        if (mUrl == null) {
            return null;
        }
        ArrayList<EarthQuakeModel> earthQuakeModels = QueryUtils.fetchEarthquakeData(mUrl);
        return earthQuakeModels;
    }
}
