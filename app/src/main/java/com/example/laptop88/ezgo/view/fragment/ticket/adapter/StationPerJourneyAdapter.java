package com.example.laptop88.ezgo.view.fragment.ticket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.StationPerJourney;

import java.util.List;

public class StationPerJourneyAdapter extends RecyclerView.Adapter<StationPerJourneyAdapter.RecyclerViewHolder> {
    private Context mContext;
    private int resource;
    private List<StationPerJourney> data;
    private FragmentManager mFragmentManager;

    public StationPerJourneyAdapter(Context mContext, List<StationPerJourney> data, FragmentManager mFragmentManager) {
        this.mContext = mContext;
        this.data = data;
        this.mFragmentManager = mFragmentManager;
    }

    public StationPerJourneyAdapter(Context mContext, int resource, List<StationPerJourney> data) {
        this.mContext = mContext;
        this.resource = resource;
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_station_per_journey, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        final String station = data.get(position).getStation();
        final String departureTime = data.get(position).getDepartureTime();
        final String arrivalTime = data.get(position).getArrivalTime();

        holder.stationName.setText(station);
        holder.depatureTime.setText(departureTime);
        holder.arrivalTime.setText(arrivalTime);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView stationName;
        TextView depatureTime;
        TextView arrivalTime;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            stationName = itemView.findViewById(R.id.StationName);
            depatureTime = itemView.findViewById(R.id.DepartureTime);
            arrivalTime = itemView.findViewById(R.id.ArrviralTime);
        }
    }
}
