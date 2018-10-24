package com.example.laptop88.ezgo.fragment.seat.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.fragment.Steamer.ShowSteamerDiagram.onSeatClickListener;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.utils.Constants;

import java.util.List;

public class SeatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Seat> seatList;
    private onSeatClickListener onSeatClickListener;

    public SeatAdapter(Context context, List<Seat> seatList, onSeatClickListener onSeatClickListener) {
        this.context = context;
        this.seatList = seatList;
        this.onSeatClickListener = onSeatClickListener;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_seat, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Seat seat = seatList.get(position);
        ((MyViewHolder) holder).steamerNumber.setText(String.valueOf(seatList.get(position).getSeatNumber()));
        for (int i = 0; i < seatList.size(); i++) {
            switch (seat.getSeatStatus()) {
                case Constants.SeatStatus.EMPTY:
                    ((MyViewHolder) holder).cardView.setClickable(true);
                    ((MyViewHolder) holder).cardView.setCardBackgroundColor(Color.parseColor(Constants.SeatStatusColor.EMPTY));
                    break;
                case Constants.SeatStatus.RESERVED:
                    ((MyViewHolder) holder).cardView.setClickable(false);
                    ((MyViewHolder) holder).cardView.setCardBackgroundColor(Color.parseColor(Constants.SeatStatusColor.RESERVED));
                    break;
                case Constants.SeatStatus.TRADING:
                    ((MyViewHolder) holder).cardView.setClickable(false);
                    ((MyViewHolder) holder).cardView.setCardBackgroundColor(Color.parseColor(Constants.SeatStatusColor.TRADING));
                    break;
                case Constants.SeatStatus.PICKING:
                    ((MyViewHolder) holder).cardView.setClickable(true);
                    ((MyViewHolder) holder).cardView.setCardBackgroundColor(Color.parseColor(Constants.SeatStatusColor.PICKING));
                default:
                    break;

            }
        }

        ((MyViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSeatClickListener.onClick(seat);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seatList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView steamerNumber;
        private CardView cardView;
        private View itemView;

        public void findView(View itemView) {
            this.itemView = itemView;
            steamerNumber = itemView.findViewById(R.id.seat_number);
            cardView = itemView.findViewById(R.id.fragment_seat);

        }

        public MyViewHolder(View itemView) {
            super(itemView);
            findView(itemView);
        }
    }
}