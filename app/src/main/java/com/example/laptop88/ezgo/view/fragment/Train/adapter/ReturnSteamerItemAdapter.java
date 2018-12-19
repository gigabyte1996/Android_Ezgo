package com.example.laptop88.ezgo.view.fragment.Train.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainDiagramFragment.ShowReturnTrainDiagramFragment;
import com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainScheduleFragment.ShowReturnTrainScheduleFragment;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment.ShowTrainDiagramFragment;

import java.util.ArrayList;
import java.util.List;

public class ReturnSteamerItemAdapter extends RecyclerView.Adapter<ReturnSteamerItemAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<Steamer> mSteamers = new ArrayList<>();
    private ShowReturnTrainDiagramFragment showReturnTrainDiagramFragment;
    private List<Seat> mSeats = new ArrayList<>();


    public ReturnSteamerItemAdapter(Context mContext, FragmentManager mFragmentManager, List<Steamer> mSteamers, ShowReturnTrainDiagramFragment showReturnTrainDiagramFragment) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.mSteamers = mSteamers;
        this.showReturnTrainDiagramFragment = showReturnTrainDiagramFragment;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_steamer, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ReturnSteamerItemAdapter.RecyclerViewHolder holder, final int position) {
        final int steamerNumber = mSteamers.get(position).getSteamerNumber();
        final Integer carrageID = mSteamers.get(position).getSteamerID();
        holder.txtSteamerNumber.setText(String.valueOf(steamerNumber));
        holder.item.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                setSteamerColor(mSteamers);
                List<Seat> seatList = new ArrayList<>();
                mSeats = mSteamers.get(position).getSeatList();
                showReturnTrainDiagramFragment.transferDataToAdapter(mSeats);
            }
        });
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
//    public void setSteamerColor(List<Steamer> mSteamers){
//        for (int i =0; i< mSteamers.size(); i++){
//            if (mSteamers.get(i).setClick(true)){
//                holder.item.setBackgroundColor(Color.parseColor(Constants.Color.COLOR_CONCEPT));
//                holder.txtSteamerNumber.setTextColor(Color.WHITE);
//            }
//        }
//    }

//    public interface handleCarrageItem{
//        void onClickItemCarrageListener(String carrageID);
//    }
}
