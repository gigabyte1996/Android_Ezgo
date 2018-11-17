package com.example.laptop88.ezgo.view.fragment.Train.adapter;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment.ShowTrainDiagramFragment;


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
    public void onBindViewHolder(@NonNull RecyclerViewItemTrainScheduleAdapter.RecyclerViewHolder holder, final int position) {
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

        holder.ticketDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, String.valueOf(data.get(position).getTrainID()), Toast.LENGTH_LONG).show();
            }
        });
        holder.btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowTrainDiagramFragment mFragment = new ShowTrainDiagramFragment();
                Bundle bundle = new Bundle();
                bundle.putString("trainID", String.valueOf(data.get(position).getTrainID()));
                mFragment.setArguments(bundle);
                pushFragment(BookingActivity.PushFrgType.REPLACE, mFragment, mFragment.getTag(), R.id.home_container);
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
        TextView txtDepatureTime;
        TextView txtArrivalTime;
        TextView ticketDetail;
        Button btnBooking;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            btnBooking = itemView.findViewById(R.id.btnBoooking);
            txtTrainName = itemView.findViewById(R.id.txtTrainName);
            txtJouneyName = itemView.findViewById(R.id.txtjouneyName);
            imgPantryCar = itemView.findViewById(R.id.imgPantryCar);
            txtDepatureTime = itemView.findViewById(R.id.txtDepartureTime);
            txtArrivalTime = itemView.findViewById(R.id.txtArrivalTime);
            ticketDetail = itemView.findViewById(R.id.ticketDetail);

        }
    }
    public void pushFragment(BookingActivity.PushFrgType type, Fragment fragment, String tag, @IdRes int mContainerId) {
        try {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            ft.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            if (type == BookingActivity.PushFrgType.REPLACE) {
                ft.replace(mContainerId, fragment, tag);
                ft.addToBackStack(fragment.getTag());
                ft.commitAllowingStateLoss();
            } else if (type == BookingActivity.PushFrgType.ADD) {
                ft.add(mContainerId, fragment, tag);
                ft.addToBackStack(fragment.getTag());
                ft.commit();
            }
            mFragmentManager.executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
