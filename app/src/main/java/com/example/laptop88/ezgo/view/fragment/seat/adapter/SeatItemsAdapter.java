//package com.example.laptop88.ezgo.view.fragment.seat.adapter;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import com.example.laptop88.ezgo.R;
//import com.example.laptop88.ezgo.response.Seat;
//import com.example.laptop88.ezgo.Utils.Constants;
//
//import java.util.List;
//
//public class SeatItemsAdapter extends BaseAdapter {
//    private List<Seat> seats;
//    private Context context;
//
//    public SeatItemsAdapter(List<Seat> seats, Context context) {
//        this.seats = seats;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return 50;
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return seats.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        if (view == null){
//            view = LayoutInflater.from(context).inflate(R.layout.steamer_diagram, viewGroup,false);
//        }
//        final Seat seat =(Seat) this.getItem(i);
//
//        TextView seatNumber = view.findViewById(R.id.seat_number);
//
//        seatNumber.setText(seat.getSeatNumber());
//        seatNumber.setBackgroundColor(Color.parseColor(setColor(seat.getSeatStatus())));
//        seatNumber.setClickable(setClickable(seat.getSeatStatus()));
//
//        return view;
//    }
//
//    private String setColor(int seatStatus) {
//        String colorCode = null;
//        switch (seatStatus){
//            case 0:
//                colorCode= Constants.SeatStatusColor.EMPTY;
//            case 1:
//                colorCode= Constants.SeatStatusColor.PICKING;
//            case 2:
//                colorCode= Constants.SeatStatusColor.RESERVED;
//            case 3:
//                colorCode= Constants.SeatStatusColor.TRADING;
//        }
//        return colorCode;
//    }
//    private boolean setClickable(int seatStatus){
//        boolean clickableStatus = false;
//        switch (seatStatus){
//            case 0 | 1:
//                clickableStatus = true;
////            case 2 | 3:
////                clickableStatus = false;
//        }
//        return clickableStatus;
//    }
////    private void changeColorOnclick(Seat seat){
////        if (seat.isClick())
////    }
//}
