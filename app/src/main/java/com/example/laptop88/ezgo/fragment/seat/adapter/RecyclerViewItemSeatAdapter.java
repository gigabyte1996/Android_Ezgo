package com.example.laptop88.ezgo.fragment.seat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Seat;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewItemSeatAdapter extends RecyclerView.Adapter<RecyclerViewItemSeatAdapter.RecyclerViewHolder> {
    private List<Seat> mSeats = new ArrayList<>();

    public RecyclerViewItemSeatAdapter(List<Seat> mSeats){

        this.mSeats = mSeats;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_seat, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        final int seatNumber = mSeats.get(position).getSeatNumber();

        holder.txtSeatNumber.setText(seatNumber);

    }

    @Override
    public int getItemCount() {
        return mSeats.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView txtSeatNumber;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            txtSeatNumber = (TextView) itemView.findViewById(R.id.seat_number);
        }
    }
}
