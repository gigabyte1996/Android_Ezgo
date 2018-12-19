package com.example.laptop88.ezgo.view.fragment.Train.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Singleton.CurrentTrainSchedule;
import com.example.laptop88.ezgo.Singleton.TicketPocket;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Steamer.ShowListSteamersDiagram.CarrageListFragment;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment.ShowTrainDiagramFragment;

import java.util.ArrayList;
import java.util.List;

public class SteamerItemAdapter extends RecyclerView.Adapter<SteamerItemAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<Steamer> mSteamers = new ArrayList<>();
    private ShowTrainDiagramFragment showTrainDiagramFragment;
    private List<Seat> mSeats = new ArrayList<>();
    private TrainSchedule mTrainSchedule;

    public SteamerItemAdapter(Context mContext, FragmentManager mFragmentManager, List<Steamer> mSteamers, ShowTrainDiagramFragment showTrainDiagramFragment) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.mSteamers = mSteamers;
        this.showTrainDiagramFragment = showTrainDiagramFragment;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_steamer, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SteamerItemAdapter.RecyclerViewHolder holder, final int position) {
        final int steamerNumber = mSteamers.get(position).getSteamerNumber();
        final Integer carrageID = mSteamers.get(position).getSteamerID();

        holder.txtSteamerNumber.setText(String.valueOf(steamerNumber));
        holder.item.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CurrentTrainSchedule.getInstance().setSteamer(mSteamers.get(position));
                List<Seat> seatList = new ArrayList<>();
                mSeats = mSteamers.get(position).getSeatList();
                showTrainDiagramFragment.transferDataToAdapter(mSeats);
            }
        });
//
    }

    @Override
    public int getItemCount() {
        return mSteamers.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtSteamerNumber;
        RelativeLayout item;
        Button btnBooking;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtSteamerNumber =(TextView) itemView.findViewById(R.id.steamer_number);
            item = (RelativeLayout) itemView.findViewById(R.id.steamer_item);
            btnBooking=(Button) itemView.findViewById(R.id.btnBoooking);
        }
    }

    public void updateCarrageList(Steamer steamer) {
        mSteamers.add(steamer);
        notifyDataSetChanged();
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
