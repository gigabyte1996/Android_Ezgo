package com.example.laptop88.ezgo.view.fragment.Train.adapter;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.TrainSchedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecyclerViewItemTrainScheduleAdapter extends RecyclerView.Adapter<RecyclerViewItemTrainScheduleAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<TrainSchedule> data = new ArrayList<>();

    public RecyclerViewItemTrainScheduleAdapter(Context mContext, FragmentManager mFragmentManager, List<TrainSchedule> data) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_train_schedule, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewItemTrainScheduleAdapter.RecyclerViewHolder holder, int position) {
        final String trainScheduleID = data.get(position).getTrainScheduleID();
        final String trainName = data.get(position).getTrainName();
        final String jouneyName = data.get(position).getJouneyName();
        final Date departureTime = data.get(position).getDepartureTime();
        final Date arrivalTime = data.get(position).getArrivalTime();
        final String firstStation = data.get(position).getFirstStation();
        final String lastStation = data.get(position).getLastStation();
        final String trainID = data.get(position).getTrainID();

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        final String departuteTimeSt = formatter.format(departureTime);
        final String arrivalTimeSt = formatter.format(arrivalTime);

        holder.txtTrainName.setText(trainName);
        holder.txtJouneyName.setText(jouneyName);
        holder.txtDepatureTime.setText(departuteTimeSt);
        holder.txtArrivalTime.setText(arrivalTimeSt);

        Bundle bundle = new Bundle();
        TrainSchedule trainSchedule = new TrainSchedule(trainScheduleID, trainName, jouneyName, departureTime, arrivalTime, firstStation, lastStation, trainID);
        bundle.putSerializable("trainSchedule", trainSchedule);
//        holder.line.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FindTrainByStationFragement mFragement = new FindTrainByStationFragement();
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        LinearLayout line;
        TextView txtTrainName;
        TextView txtJouneyName;
        ImageView imgPantryCar;
        TextView txtDepatureTime;
        TextView txtArrivalTime;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            line = itemView.findViewById(R.id.line);
            txtTrainName = itemView.findViewById(R.id.txtTrainName);
            txtJouneyName = itemView.findViewById(R.id.txtjouneyName);
            imgPantryCar = itemView.findViewById(R.id.imgPantryCar);
            txtDepatureTime = itemView.findViewById(R.id.txtDepartureTime);
            txtArrivalTime = itemView.findViewById(R.id.txtArrivalTime);

        }
    }
}
