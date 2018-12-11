package com.example.laptop88.ezgo.view.fragment.Train.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Singleton.CurrentTrainSchedule;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainDiagramFragment.ShowReturnTrainDiagramFragment;
import com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainScheduleFragment.ShowReturnTrainScheduleFragment;

import java.text.SimpleDateFormat;
import java.util.List;

public class ReturnSeatItemAdapter extends RecyclerView.Adapter<ReturnSeatItemAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<Seat> mSeats ;
    private TrainSchedule trainSchedule;
    private Steamer steamer;
    private SeatStorage seatStorage;
    private ShowReturnTrainDiagramFragment showReturnTrainDiagramFragment;

    public ReturnSeatItemAdapter(Context mContext, FragmentManager mFragmentManager, List<Seat> mSeats, ShowReturnTrainDiagramFragment showReturnTrainDiagramFragment) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.mSeats = mSeats;
        this.showReturnTrainDiagramFragment = showReturnTrainDiagramFragment;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_seat, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, final int position) {
        final Seat seat = mSeats.get(position);

        final int seatID = seat.getSeatID();
        final int seatType = seat.getSeatType();
        final int seatNumber = seat.getSeatNumber();

        holder.txtSeatNumber.setText(String.valueOf(seatNumber));
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        switch (seat.getSeatStatus()){
            case Constants.SeatStatus.EMPTY:
                holder.cardView.setBackgroundColor(Color.parseColor(Constants.SeatStatusColor.EMPTY));
                break;
            case Constants.SeatStatus.RESERVED:
                holder.cardView.setBackgroundColor(Color.parseColor(Constants.SeatStatusColor.RESERVED));
                break;
            case Constants.SeatStatus.TRADING:
                holder.cardView.setBackgroundColor(Color.parseColor(Constants.SeatStatusColor.TRADING));
                break;
            case Constants.SeatStatus.PICKING:
                holder.cardView.setBackgroundColor(Color.parseColor(Constants.SeatStatusColor.PICKING));
            default:
                break;
        }
       holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (seat.getSeatStatus()){
                    case Constants.SeatStatus.EMPTY:

                        steamer = new Steamer();
                        trainSchedule = new TrainSchedule();
                        steamer = CurrentTrainSchedule.getInstance().getSteamer();
                        trainSchedule = CurrentTrainSchedule.getInstance().getDepartureSchedule();
                        seatStorage = new SeatStorage();
                        seatStorage.setUserID(1);
                        seatStorage.setTrainName(trainSchedule.getTrainName());
                        seatStorage.setScheduleName(trainSchedule.getJouneyName());
                        seatStorage.setDepartureTime(sdf.format(trainSchedule.getDepartureTime()));
                        seatStorage.setCarrageNumber(steamer.getSteamerNumber());
                        seatStorage.setCarrageType(steamer.getSteamerType());
                        seatStorage.setSeatLocation(seat.getSeatNumber());
                        seatStorage.setFare(200000);
                        seatStorage.setSeatID(seatID);
                        seatStorage.setTrainScheduleID(trainSchedule.getTrainScheduleID());
                        seatStorage.setSeatNumber(seatNumber);
                        seatStorage.setFromStation(trainSchedule.getFirstStation());
                        seatStorage.setToStation(trainSchedule.getLastStation());
                        showReturnTrainDiagramFragment.addSeat(seatStorage);
                        holder.cardView.setBackgroundColor(Color.parseColor(Constants.SeatStatusColor.PICKING));
                        seat.setSeatStatus(Constants.SeatStatus.PICKING);
//                        saveSeatStatus.onClickSeatListener(mSeats.get(position).getSeatID());
                        break;
                    case Constants.SeatStatus.RESERVED:
                        Toast.makeText(mContext, "Ghe da co nguoi dat", Toast.LENGTH_SHORT).show();
//                            holder.cardView.setBackgroundColor(Color.parseColor(Constants.SeatStatusColor.RESERVED));
                        break;
                    case Constants.SeatStatus.TRADING:
                        Toast.makeText(mContext, "Ghe dang duoc giao dich", Toast.LENGTH_SHORT).show();
//                            holder.cardView.setBackgroundColor(Color.parseColor(Constants.SeatStatusColor.TRADING));
                        break;
                    case Constants.SeatStatus.PICKING:

                        trainSchedule = new TrainSchedule();
                        trainSchedule = CurrentTrainSchedule.getInstance().getDepartureSchedule();
                        SeatStorageDeleteRequest seatStorageDeleteRequest = new SeatStorageDeleteRequest(seatID, trainSchedule.getTrainScheduleID());
                        trainSchedule = CurrentTrainSchedule.getInstance().getDepartureSchedule();

                        showReturnTrainDiagramFragment.deleteSeat(seatStorageDeleteRequest);
                        holder.cardView.setBackgroundColor(Color.parseColor(Constants.SeatStatusColor.EMPTY));
                        seat.setSeatStatus(Constants.SeatStatus.EMPTY);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSeats.size();
    }
     class RecyclerViewHolder extends RecyclerView.ViewHolder {
            TextView txtSeatNumber;
            LinearLayout cardView;

         public RecyclerViewHolder(View itemView) {
             super(itemView);
             txtSeatNumber = (TextView)itemView.findViewById(R.id.seat_number);
             cardView = itemView.findViewById(R.id.item_seat);

         }
     }
     public void updateList(List<Seat> newList)
     {
         this.mSeats=newList;
         notifyDataSetChanged();

     }


}
