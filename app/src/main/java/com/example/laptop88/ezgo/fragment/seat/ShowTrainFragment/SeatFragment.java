package com.example.laptop88.ezgo.fragment.seat.ShowTrainFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeatFragment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @BindView(R.id.fragment_seat)
    LinearLayout llItemSeat;

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.item_seat, container, false);
//        ButterKnife.bind(this,view);
//
//        return view;
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

//    @OnClick(R.id.fragment_seat)
//    public void changeColor(int position){
////        switch (view.getId()){
////            case
////            if (view.isClickable()){
////                view.setBackgroundColor(Color.parseColor(Constants.SeatStatusColor.PICKING));
////            }
////        }

    }

