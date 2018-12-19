package com.example.laptop88.ezgo.view.fragment.Train.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Utils.Utils;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainDiagramFragment.ShowReturnTrainDiagramFragment;
import com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainScheduleFragment.ShowReturnTrainScheduleFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemReturnTrainScheduleAdapter extends RecyclerView.Adapter<ItemReturnTrainScheduleAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<TrainSchedule> data = new ArrayList<>();
    private ShowReturnTrainScheduleFragment mShowReturnTrainScheduleFragment;


    public ItemReturnTrainScheduleAdapter(Context mContext, FragmentManager mFragmentManager, List<TrainSchedule> data, ShowReturnTrainScheduleFragment mShowReturnTrainScheduleFragment) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.data = data;
        this.mShowReturnTrainScheduleFragment = mShowReturnTrainScheduleFragment;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_return_train_schedule, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemReturnTrainScheduleAdapter.RecyclerViewHolder holder, final int position) {
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

        holder.txtTrainName.setText(trainName);
        holder.txtJouneyName.setText(jouneyName);
        holder.txtDepartureTime.setText(departureDate);
        holder.txtArrivalDate.setText(arrivalDate);
        holder.txtArrivalTime.setText(arrivalTime);
        holder.txtDepartureTime.setText(departureTime);

        holder.ticketDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, String.valueOf(data.get(position).getTrainID()), Toast.LENGTH_LONG).show();
            }
        });

        holder.btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowReturnTrainScheduleFragment.setPopUpAdapter(data.get(position).getStationPerJourneys());
            }
        });
        holder.btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getReturnTrainID.onClickReturnTrainScheduleListener(data.get(position).getTrainID());
                mShowReturnTrainScheduleFragment.onClickReturnTrainSchedule(data.get(position).getTrainScheduleID());
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
        TextView txtDepartureTime;
        TextView txtArrivalTime;
        TextView txtDepartureDate;
        TextView txtArrivalDate;
        TextView ticketDetail;
        Button btnBooking;
        TextView btnSchedule;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            btnBooking = itemView.findViewById(R.id.btnBoooking);
            txtTrainName = itemView.findViewById(R.id.txtTrainName);
            txtJouneyName = itemView.findViewById(R.id.txtjouneyName);
            imgPantryCar = itemView.findViewById(R.id.imgPantryCar);
            txtDepartureTime = itemView.findViewById(R.id.txtDepartureTime);
            txtArrivalTime = itemView.findViewById(R.id.txtArrivalTime);
            txtDepartureDate = itemView.findViewById(R.id.txtDepartureDate);
            txtArrivalDate = itemView.findViewById(R.id.txtArrivalDate);
            ticketDetail = itemView.findViewById(R.id.ticketDetail);
            btnSchedule = itemView.findViewById(R.id.btnSchedule);
        }
    }
}
