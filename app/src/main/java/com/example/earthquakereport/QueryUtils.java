package com.example.earthquakereport;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */
public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Return a list of {@link EarthQuakeModel} objects that has been built up from
     * parsing a JSON response.
     *
     * @return
     */
    private static ArrayList<EarthQuakeModel> extractEarthquakes(String earthQuakeM) {
        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<EarthQuakeModel> earthquakes = new ArrayList<>();

        if (TextUtils.isEmpty(earthQuakeM)) {
            return null;
        }


        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of Earthquake objects with the corresponding data.
            JSONObject baseJsonResponse = new JSONObject(earthQuakeM);
            JSONArray earthQuakeArray = baseJsonResponse.getJSONArray("features");
            for (int i = 0; i < earthQuakeArray.length(); i++) {
                JSONObject currentEarthQuake = earthQuakeArray.getJSONObject(i);
                JSONObject properties = currentEarthQuake.getJSONObject("properties");

                Double magnitude = properties.getDouble("mag");
                String location = properties.getString("place");
                String date = properties.getString("time");
                Long longTime = properties.getLong("time");
                String url = properties.getString("url");

                earthquakes.add(new EarthQuakeModel(magnitude, location, date, longTime, url));

            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return earthquakes;
    }

    public static ArrayList<EarthQuakeModel> fetchEarthquakeData(String earthQuakeModel) {
        Log.i(LOG_TAG, "testing fecth eartquakedata get JsonData");

        URL url = createUrl(earthQuakeModel);

        String jsonRespone = null;
        try {
            //delay between get fecth
//            Thread.sleep(1500);
            jsonRespone = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "error closing input stream", e);
        }

        ArrayList<EarthQuakeModel> quakeModel = extractEarthquakes(jsonRespone);

        return quakeModel;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonRespone = "";

        if (url == null) {
            return jsonRespone;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonRespone = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, " Error Respone Code displayed: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, " problem retrivieng the earthquake JSON result", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return jsonRespone;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    static URL createUrl(String earthQuakeModelUrl) {

        URL url = null;
        try {
            url = new URL(earthQuakeModelUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }


}