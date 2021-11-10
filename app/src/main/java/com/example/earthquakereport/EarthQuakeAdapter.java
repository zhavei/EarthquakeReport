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

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuakeModel> {

    public EarthQuakeAdapter( Context context, ArrayList<EarthQuakeModel> earthQuake) {
        super(context, 0, earthQuake);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        ViewHolder viewHolder;

        if (itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
            viewHolder = new ViewHolder(itemView);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }

        EarthQuakeModel currentPosition = getItem(position);
        viewHolder.textViewMag.setText(currentPosition.getMagnitude());
        viewHolder.textViewLocation.setText(currentPosition.getLocation());
        viewHolder.textViewDate.setText(currentPosition.getDate());

        return itemView;
    }

    private class ViewHolder {
        TextView textViewMag, textViewLocation, textViewDate;

        public ViewHolder(View convertView){
            textViewMag = convertView.findViewById(R.id.tv_magnitude);
            textViewMag = convertView.findViewById(R.id.tv_location);
            textViewMag = convertView.findViewById(R.id.tv_date);
        }
    }
}
