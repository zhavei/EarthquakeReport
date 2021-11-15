package com.example.earthquakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

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


        if (itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
            viewHolder = new ViewHolder(itemView);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }

        viewHolder.textViewMag.setText(currentPosition.getMagnitude());
        viewHolder.textViewLocation.setText(currentPosition.getLocation());
        viewHolder.textViewDate.setText(currentPosition.getDate());

        viewHolder.textViewTime.setText(currentPosition.getLongTime());


        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentPosition.getLongTime());


        // Find the TextView with view ID date

        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time

        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        return itemView;
    }


}
