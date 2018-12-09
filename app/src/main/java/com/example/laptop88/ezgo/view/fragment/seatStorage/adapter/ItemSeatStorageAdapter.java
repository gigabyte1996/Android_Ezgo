package com.example.laptop88.ezgo.view.fragment.seatStorage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.ItemTrainScheduleAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemSeatStorageAdapter extends  RecyclerView.Adapter<ItemSeatStorageAdapter.RecyclerViewHolder>{
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<SeatStorage> data = new ArrayList<>();

    public ItemSeatStorageAdapter(Context mContext, FragmentManager mFragmentManager, List<SeatStorage> data) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_list_seat_storage, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemSeatStorageAdapter.RecyclerViewHolder holder, int position) {
        final String trainName = data.get(position).getTrainName();
        final String trainScheduleName = data.get(position).getScheduleName();
        final String departureTime = data.get(position).getDepartureTime();
        final Integer carrageType = data.get(position).getCarrageType();
        final Integer carrageNumber = data.get(position).getCarrageNumber();
        final Integer seatNumber = data.get(position).getSeatNumber();

        holder.txtTrainName.setText(trainName);
        holder.txtTrainScheduleName.setText(trainScheduleName);
        holder.txtDepartureTime.setText(departureTime);
        holder.txtCarrageType.setText(carrageType);
        holder.txtCarrageNumber.setText(carrageNumber);
        holder.txtSeatNumber.setText(seatNumber);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView txtTrainName;
        TextView txtTrainScheduleName;
        TextView txtDepartureTime;
        TextView txtCarrageType;
        TextView txtCarrageNumber;
        TextView txtSeatNumber;
        ImageView imgDelete;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtCarrageNumber = itemView.findViewById(R.id.txtCarrageNumber);
            txtTrainName = itemView.findViewById(R.id.TrainName);
            txtTrainScheduleName = itemView.findViewById(R.id.TrainScheduleName);
            txtDepartureTime = itemView.findViewById(R.id.llDepartureTime);
            txtCarrageType = itemView.findViewById(R.id.txtCarrageType);
            txtSeatNumber = itemView.findViewById(R.id.txtSeatNumber);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}
