package com.example.laptop88.ezgo.view.fragment.Train.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.view.fragment.seat.SeatDiagram.SeatDiagramFragment;

import java.util.ArrayList;
import java.util.List;

public class SeatItemAdapter extends RecyclerView.Adapter<SeatItemAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<Seat> mSeats = new ArrayList<>();

    public SeatItemAdapter(Context mContext, FragmentManager mFragmentManager, List<Seat> mSeats) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.mSeats = mSeats;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_steamer, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SeatItemAdapter.RecyclerViewHolder holder, int position) {
        final int seatNumber = mSeats.get(position).getSeatNumber();
        final int seatID = mSeats.get(position).getSeatID();
        final int seatType = mSeats.get(position).getSeatType();
        final int seatStatus = mSeats.get(position).getSeatStatus();
        final Seat seat = mSeats.get(position);
        holder.txtSeatNumber.setText(String.valueOf(seatNumber));
        holder.item.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                for (Seat seat : mSeats){
                    if (seat.getSeatType()==0 || seat.getSeatType()==1){
                        holder.seat.setVisibility(View.VISIBLE);
                        holder.seat.setVisibility(View.GONE);
                    }else {
                        holder.bed.setVisibility(View.VISIBLE);
                        holder.seat.setVisibility(View.GONE);
                    }
                    switch (seat.getSeatStatus()){
                        case Constants.SeatStatus.EMPTY:
                            holder.cardView.setClickable(true);
                            holder.cardView.setCardBackgroundColor(Color.parseColor(Constants.SeatStatusColor.EMPTY));
                            break;
                        case Constants.SeatStatus.RESERVED:
                            holder.cardView.setClickable(false);
                            holder.cardView.setCardBackgroundColor(Color.parseColor(Constants.SeatStatusColor.RESERVED));
                            break;
                        case Constants.SeatStatus.TRADING:
                            holder.cardView.setClickable(false);
                            holder.cardView.setCardBackgroundColor(Color.parseColor(Constants.SeatStatusColor.TRADING));
                            break;
                        case Constants.SeatStatus.PICKING:
                            holder.cardView.setClickable(true);
                            holder.cardView.setCardBackgroundColor(Color.parseColor(Constants.SeatStatusColor.PICKING));
                        default:
                            break;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSeats.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        View seat;
        View bed;
        CardView cardView;
        TextView txtSeatNumber;
        LinearLayout item;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtSeatNumber =(TextView) itemView.findViewById(R.id.seat_number);
            item = (LinearLayout) itemView.findViewById(R.id.item_seat);
            cardView = itemView.findViewById(R.id.item_seat);
            seat = itemView.findViewById(R.id.seat);
            bed = itemView.findViewById(R.id.bed);

        }

    }

}
