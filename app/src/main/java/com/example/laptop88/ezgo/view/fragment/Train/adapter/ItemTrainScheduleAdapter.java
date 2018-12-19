package com.example.laptop88.ezgo.view.fragment.Train.adapter;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Utils.ScreenUtils;
import com.example.laptop88.ezgo.Utils.Utils;
import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment.ShowTrainDiagramFragment;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragment;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ItemTrainScheduleAdapter extends RecyclerView.Adapter<ItemTrainScheduleAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<TrainSchedule> data = new ArrayList<>();
    private GetTrainID getTrainID;
    private ShowTrainScheduleFragment mShowTrainScheduleFragment;



    public ItemTrainScheduleAdapter(Context mContext, FragmentManager mFragmentManager, List<TrainSchedule> data, GetTrainID getTrainID, ShowTrainScheduleFragment mShowTrainScheduleFragment) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.data = data;
        this.getTrainID = getTrainID;
        this.mShowTrainScheduleFragment = mShowTrainScheduleFragment;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_train_schedule, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemTrainScheduleAdapter.RecyclerViewHolder holder, final int position) {
        final Integer trainScheduleID = data.get(position).getTrainScheduleID();
        final String trainName = data.get(position).getTrainName();
        final String jouneyName = data.get(position).getJouneyName();
        final String departureDate = Utils.splitDate(data.get(position).getDepartureTime())[0];
        final String arrivalDate = Utils.splitDate(data.get(position).getArrivalTime())[0];
        final String firstStation = data.get(position).getFirstStation();
        final String lastStation = data.get(position).getLastStation();
        final Integer trainID = data.get(position).getTrainID();
        final String departureTime = Utils.splitDate(data.get(position).getDepartureTime())[1];
        final  String arrivalTime = Utils.splitDate(data.get(position).getArrivalTime())[1];
        final Long durationHours = Utils.getDuration(data.get(position).getDepartureTime(), data.get(position).getArrivalTime())[0];
        final Long durationMinutes = Utils.getDuration(data.get(position).getDepartureTime(), data.get(position).getArrivalTime())[1];
        final  String duration = durationHours +" hr"+durationMinutes+" min";


        holder.txtTrainName.setText(trainName);
        holder.txtJouneyName.setText(jouneyName);
        holder.txtDepatureDate.setText(departureDate);
        holder.txtArrivalDate.setText(arrivalDate);
        holder.txtArrivalTime.setText(arrivalTime);
        holder.txtDepartureTime.setText(departureTime);
        holder.duration.setText(duration);

        holder.ticketDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, String.valueOf(data.get(position).getTrainID()), Toast.LENGTH_LONG).show();
            }
        });

        holder.txtSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowTrainScheduleFragment.setPopUpAdapter(data.get(position).getStationPerJourneys());
            }
        });
        holder.btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTrainID.onClickTrainScheduleListener(data.get(position));
                Log.d("position", String.valueOf(position) + data.get(position).getTrainID());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtTrainName;
        TextView txtJouneyName;
        ImageView imgPantryCar;
        TextView ticketDetail;
        Button btnBooking;
        TextView txtSchedule;
        TextView txtDepatureDate;
        TextView txtArrivalDate;
        TextView txtDepartureTime;
        TextView txtArrivalTime;
        TextView duration;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            btnBooking = itemView.findViewById(R.id.btnBoooking);
            txtTrainName = itemView.findViewById(R.id.txtTrainName);
            txtJouneyName = itemView.findViewById(R.id.txtjouneyName);
            imgPantryCar = itemView.findViewById(R.id.imgPantryCar);
            txtDepatureDate = itemView.findViewById(R.id.txtDepartureDate);
            txtArrivalDate = itemView.findViewById(R.id.txtArrivalDate);
            ticketDetail = itemView.findViewById(R.id.ticketDetail);
            txtSchedule = itemView.findViewById(R.id.txtSchedule);
            txtDepartureTime = itemView.findViewById(R.id.txtDepartureTime);
            txtArrivalTime = itemView.findViewById(R.id.txtArrivalTime);
            duration = itemView.findViewById(R.id.duration);
        }
    }


    public void sortByDepartureTime() {
        Collections.sort(data, new Comparator<TrainSchedule>() {
            @Override
            public int compare(TrainSchedule trainSchedule1, TrainSchedule trainSchedule2) {
                return Double.compare(Utils.getTime(trainSchedule1.getDepartureTime()), Utils.getTime(trainSchedule2.getDepartureTime()));
            }
        });
        notifyDataSetChanged();
    }

    public void sortByArrivalTime() {
        Collections.sort(data, new Comparator<TrainSchedule>() {
            @Override
            public int compare(TrainSchedule trainSchedule1, TrainSchedule trainSchedule2) {
                return Double.compare(Utils.getTime(trainSchedule1.getArrivalTime()), Utils.getTime(trainSchedule2.getArrivalTime()));
            }
        });
        notifyDataSetChanged();
    }

    public void sortByDuration() {
        Collections.sort(data, new Comparator<TrainSchedule>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public int compare(TrainSchedule ts1, TrainSchedule ts2) {
                return Long.compare(Utils.getDurationInLongFormat(ts1.getDepartureTime(), ts1.getArrivalTime()), Utils.getDurationInLongFormat(ts2.getDepartureTime(),ts2.getArrivalTime()));
            }
        });
        notifyDataSetChanged();
    }

    public void sortByTicketFare() {
    }

    public interface GetTrainID{
        void onClickTrainScheduleListener(TrainSchedule trainSchedule);
    }

}
