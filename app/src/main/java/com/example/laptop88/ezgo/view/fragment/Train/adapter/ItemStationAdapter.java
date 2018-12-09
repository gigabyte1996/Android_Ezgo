package com.example.laptop88.ezgo.view.fragment.Train.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Station;

import java.util.ArrayList;
import java.util.List;

public class ItemStationAdapter extends ArrayAdapter {
    Context mContext;
    int resourceID;
    List<Station> stations;

    public ItemStationAdapter(Context context, int resource, List<Station> stations) {
        super(context, resource, stations);
        this.mContext = context;
        this.resourceID = resource;
        this.stations = stations;
    }

    @Override
    public Station getItem(int position) {
        return stations.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        row = inflater.inflate(R.layout.item_station, parent, false);

        TextView text = (TextView) row.findViewById(R.id.txtStation);

        text.setText(stations.get(position).getStationName());
        return row;
    }
}
