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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Steamer.ShowListSteamersDiagram.CarrageListFragment;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewSteamerItemAdapter extends RecyclerView.Adapter<RecyclerViewSteamerItemAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<Steamer> mSteamers = new ArrayList<>();

    public RecyclerViewSteamerItemAdapter(Context mContext, FragmentManager mFragmentManager, List<Steamer> mSteamers) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.mSteamers = mSteamers;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_steamer, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewSteamerItemAdapter.RecyclerViewHolder holder, int position) {
        final int steamerNumber = mSteamers.get(position).getSteamerNumber();
        final String carrageID = mSteamers.get(position).getSteamerID();
        holder.txtSteamerNumber.setText(steamerNumber);
        holder.item.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CarrageListFragment mFragment = new CarrageListFragment();
                Bundle bundle = new Bundle();
                bundle.putString("carrageID",carrageID);
                mFragment.setArguments(bundle);
                pushFragment(BookingActivity.PushFrgType.ADD, mFragment, mFragment.getTag(), R.id.home_container);
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
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtSteamerNumber =(TextView) itemView.findViewById(R.id.steamer_number);
            item = (RelativeLayout) itemView.findViewById(R.id.steamer_item);

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
