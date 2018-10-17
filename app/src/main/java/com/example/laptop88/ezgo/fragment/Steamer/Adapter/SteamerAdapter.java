package com.example.laptop88.ezgo.fragment.Steamer.Adapter;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.fragment.seat.adapter.SeatItemsAdapter;
import com.example.laptop88.ezgo.response.Seat;

import java.util.List;

public class SteamerAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Seat> seatList;

    public SteamerAdapter(Context context, int layout, List<Seat> seatList) {
        this.context = context;
        this.layout = layout;
        this.seatList = seatList;
    }

    @Override
    public int getCount() {
        return seatList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private  class ViewHolder{
        CardView seat;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.seat = view.findViewById(R.id.fragment_seat);
            view.setTag(viewHolder);
        }else {
            viewHolder =(ViewHolder) view.getTag();
        }
        Seat seat = seatList.get(i);
        return null;
    }
}
