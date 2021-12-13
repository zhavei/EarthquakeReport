package com.example.earthquakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuakeModel> {

    private static final String LOCATION_SEPARATOR = "of";

    public EarthQuakeAdapter(Context context, ArrayList<EarthQuakeModel> earthQuake) {
        super(context, 0, earthQuake);
    }

    private static class ViewHolder {
        TextView textViewMag, textViewLocation, textViewDate, textViewTime, textViewoffsetLocation;
        ImageView viewClick;

        public ViewHolder(View convertView) {
            textViewMag = convertView.findViewById(R.id.tv_magnitude);
            textViewoffsetLocation = convertView.findViewById(R.id.tv_location_offset);
            textViewLocation = convertView.findViewById(R.id.tv_location);
            textViewDate = convertView.findViewById(R.id.tv_date);
            textViewTime = convertView.findViewById(R.id.tv_time);

            viewClick = convertView.findViewById(R.id.view_to_intent);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        EarthQuakeModel currentPosition = getItem(position);
        View itemView = convertView;
        ViewHolder viewHolder;

        //viewHolder Patern
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
            viewHolder = new ViewHolder(itemView);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }

        //inflate to textview

        String formattedMag = formatMagnitude(currentPosition.getMagnitude());
        viewHolder.textViewMag.setText(formattedMag);

        viewHolder.textViewLocation.setText(currentPosition.getLocation());

        //get dateobject from position
        Date dateObject = new Date(currentPosition.getLongTime());

        String formattedDate = formatDate(dateObject);
        // Find the TextView with view ID time
        viewHolder.textViewDate.setText(formattedDate);

        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        viewHolder.textViewTime.setText(formattedTime);

        //indentify for split string
        String primaryLocation;
        String locationOffset;
        //split string location
        String originalLocation = currentPosition.getLocation();
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_The);
            primaryLocation = originalLocation;
        }

        //inflate to location IDs textview
        viewHolder.textViewoffsetLocation.setText(locationOffset);
        viewHolder.textViewLocation.setText(primaryLocation);

        //set colors for magnitude
        GradientDrawable magnitudeCircle = (GradientDrawable) viewHolder.textViewMag.getBackground();
        int magnitudeColoors = getMagnitudeColors(currentPosition.getMagnitude());
        magnitudeCircle.setColor(magnitudeColoors);

        //view Icon onClick
        viewHolder.viewClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Open Browser", Toast.LENGTH_SHORT).show();

                Uri earthQuakeUri = Uri.parse(currentPosition.getUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, earthQuakeUri);
                getContext().startActivity(webIntent);
            }
        });

        return itemView;
    }

    private int getMagnitudeColors(Double magnitude) {
        int magnitudeColorsResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorsResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorsResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorsResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorsResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorsResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorsResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorsResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorsResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorsResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorsResourceId = R.color.magnitude10plus;
                break;

        }
        return ContextCompat.getColor(getContext(), magnitudeColorsResourceId);
    }

    //method format double for Magnitude/
    private String formatMagnitude(Double magnitude) {
        DecimalFormat magFormat = new DecimalFormat("0.0");
        return magFormat.format(magnitude);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd LLLL yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


}
