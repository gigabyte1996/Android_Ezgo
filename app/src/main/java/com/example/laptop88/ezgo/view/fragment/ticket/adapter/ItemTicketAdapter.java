package com.example.laptop88.ezgo.view.fragment.ticket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.view.fragment.ticket.ShowTicketFragment.ShowTicketFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ItemTicketAdapter extends RecyclerView.Adapter<ItemTicketAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<Ticket> data;
    private ShowTicketFragment mShowTicketFragment;

    public ItemTicketAdapter(Context mContext, FragmentManager mFragmentManager, List<Ticket> data) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ticket, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {
//        SimpleDateFormat sdfTime =  new SimpleDateFormat("hh:mm   yyyy-MM-dd", Locale.CHINA);
//        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        final String trainScheduleCode = data.get(position).getTrainScheduleCode();
//        final Date dateCreate = data.get(position).getDateCreate();
        final String fromStation = data.get(position).getFromStation();
        final String toStation = data.get(position).getToStation();
        final String departureTime = data.get(position).getDepartureTime();
        final Integer carrageType = data.get(position).getCarrageType();
        final Integer carrageNumber = data.get(position).getCarrageNumber();
        final Integer seatNumber = data.get(position).getSeatNumber();
        final Integer ticketStatus = data.get(position).getTicketStatus();


        holder.txtTrainScheduleCode.setText(trainScheduleCode);
//        holder.txtDateCreate.setText(sdfTime.format(dateCreate));
        holder.txtFromStation.setText(fromStation);
        holder.txtToStation.setText(toStation);
        holder.txtDepartureTime.setText(departureTime);
        switch (carrageType) {
            case Constants.CarrageType.SOFT_SEAT: {
                holder.txtCarrageType.setText("Soft seat");
                break;
            }
            case Constants.CarrageType.HARD_BED: {
                holder.txtCarrageType.setText("Hard bed");
                break;
            }
            case Constants.CarrageType.SOFT_BED: {
                holder.txtCarrageType.setText("Soft bed");
                break;
            }
            case Constants.CarrageType.HARD_SEAT: {
                holder.txtCarrageType.setText("Hard seat");
                break;
            }
        }
        holder.txtCarrageNumber.setText(String.valueOf(carrageNumber));
        holder.txtSeatNumber.setText(String.valueOf(seatNumber));

        holder.llTicketItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowTicketFragment.showTicketDetail(data.get(position).getTicketID());

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView txtTrainScheduleCode;
        TextView txtDateCreate;
        TextView txtFromStation;
        TextView txtToStation;
        TextView txtDepartureTime;
        TextView txtCarrageType;
        TextView txtCarrageNumber;
        TextView txtSeatNumber;
        TextView txtTicketStatus;
        LinearLayout llTicketItem;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtTrainScheduleCode = itemView.findViewById(R.id.txtTrainScheduleCode);
            txtDateCreate = itemView.findViewById(R.id.txtDateCreate);
            txtFromStation = itemView.findViewById(R.id.txtFromStation);
            txtToStation = itemView.findViewById(R.id.txtToStation);
            txtDepartureTime = itemView.findViewById(R.id.txtDepartureTime);
            txtCarrageType = itemView.findViewById(R.id.txtCarrageType);
            txtCarrageNumber = itemView.findViewById(R.id.txtCarrageNumber);
            txtSeatNumber = itemView.findViewById(R.id.txtSeatNumber);
            txtTicketStatus = itemView.findViewById(R.id.txtTicketStatus);
            llTicketItem = itemView.findViewById(R.id.llTicketItem);
        }
    }
}
