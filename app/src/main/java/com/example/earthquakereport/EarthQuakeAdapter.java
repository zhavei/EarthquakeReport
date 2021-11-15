package com.example.earthquakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuakeModel> {

    public EarthQuakeAdapter( Context context, ArrayList<EarthQuakeModel> earthQuake) {
        super(context, 0, earthQuake);
    }

    private static class ViewHolder {
        TextView textViewMag, textViewLocation, textViewDate, textViewTime;

        public ViewHolder(View convertView){
            textViewMag = convertView.findViewById(R.id.tv_magnitude);
            textViewLocation = convertView.findViewById(R.id.tv_location);
            textViewDate = convertView.findViewById(R.id.tv_date);
            textViewTime = convertView.findViewById(R.id.tv_time);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        EarthQuakeModel currentPosition = getItem(position);
        View itemView = convertView;
        ViewHolder viewHolder;


        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
            viewHolder = new ViewHolder(itemView);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }

        viewHolder.textViewMag.setText(currentPosition.getMagnitude());
        viewHolder.textViewLocation.setText(currentPosition.getLocation());

        Date dateObject = new Date(currentPosition.getLongTime());

        String formattedDate = formatDate(dateObject);
        // Find the TextView with view ID time
        viewHolder.textViewDate.setText(formattedDate);

        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        viewHolder.textViewTime.setText(formattedTime);

        return itemView;
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
