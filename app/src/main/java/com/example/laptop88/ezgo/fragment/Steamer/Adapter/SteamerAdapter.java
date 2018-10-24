package com.example.laptop88.ezgo.fragment.Steamer.Adapter;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.fragment.Steamer.ShowSteamerDiagram.onSteamerClickListener;
import com.example.laptop88.ezgo.fragment.seat.ShowTrainFragment.SeatFragment;
import com.example.laptop88.ezgo.fragment.seat.adapter.SeatItemsAdapter;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.utils.Constants;
import com.example.laptop88.ezgo.view.activity.booking.FindTrainsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SteamerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Steamer> steamerList;
    private onSteamerClickListener onSteamerClickListener;

    public SteamerAdapter(Context context, List<Steamer> steamerList, com.example.laptop88.ezgo.fragment.Steamer.ShowSteamerDiagram.onSteamerClickListener onSteamerClickListener) {
        this.context = context;
        this.steamerList = steamerList;
    }

    @NonNull
    @Override
    public SteamerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_seat, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
//        holder.tv_seat_Numver.setText(seats.get(position).getSeatNumber());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, SeatFragment.class);
//
//                //passong data to the book activity
//                intent.putExtra("Number", seats.get(position).getSeatNumber());
//
//                //start the activity
//                context.startActivity(intent);
//            }
//        });
        final Steamer steamer = steamerList.get(position);
        int seatLeft = 0;
        for (int i = 0; i < steamerList.get(position).getSeatList().size(); i++){
            if (steamerList.get(position).getSeatList().get(i).getSeatStatus() == Constants.SeatStatus.EMPTY) {
                seatLeft += 1;
            }
        }
        ((MyViewHolder) viewHolder).steamerNumber.setText(steamerList.get(position).getSteamerNumber());

        if (seatLeft == 0){
            ((MyViewHolder)viewHolder).cardView.setClickable(false);
            ((MyViewHolder)viewHolder).cardView.setCardBackgroundColor(Color.RED);
        } else {
            ((MyViewHolder) viewHolder).cardView.setClickable(true);
        }
        ((MyViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSteamerClickListener.onClick(steamer);

            }
        });
    }

    @Override
    public int getItemCount() {
        return steamerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView steamerNumber;
        private CardView cardView;
        private View view;

        public void findView(View view){
            this.cardView = cardView;
            this.steamerNumber = view.findViewById(R.id.steamer_number);
            this.cardView = view.findViewById(R.id.fragment_steamer);

        }

        public MyViewHolder(View itemView) {
            super(itemView);
            findView(itemView);
        }
    }
}
