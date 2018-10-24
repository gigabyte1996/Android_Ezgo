package com.example.laptop88.ezgo.fragment.Steamer.ShowSteamerDiagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.fragment.Steamer.Adapter.SteamerAdapter;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.response.Steamer;

import java.util.ArrayList;
import java.util.List;

public class SteamerFragment extends AppCompatActivity implements onSteamerClickListener {
//    List<Seat> seats;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.steamer_diagram);
//
//        seats = new ArrayList<>();
//        for (int i =0; i<50; i++){
//            for (int j = 0; j<50; j++){
//                if (i==j){
//                    seats.add(new Seat(j, 0));
//                }
//            }
//        }
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerViewSeat);
//        SteamerAdapter steamerAdapter= new SteamerAdapter(this, seats);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
//        recyclerView.setAdapter(steamerAdapter);
//    }
private RecyclerView recyclerView;
    private List<Steamer> steamList;
    private List<Seat> seatList;
    private Steamer steam1,steam2,steam3,steam4;
    private Seat seat1,seat2,seat3,seat4,seat5,seat6,seat7,seat8,seat9,seat10;
    private onSteamerClickListener onSteamerClickListener;
    private SteamerAdapter steamAdapter;
    private TextView number;
    private int seat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steamer_diagram);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewSeat);
        number = (TextView) findViewById(R.id.seat_number);
        steamList = new ArrayList<>();
        seatList = new ArrayList<>();
        onSteamerClickListener = this;
        Intent intent = getIntent();
        seat = intent.getIntExtra("seat", 1);
        number.setText( " So ghe cua ban " + String.valueOf(seat));

        seat1 = new Seat("0", 1, 1);
        seat2 = new Seat("1", 2, 1);
        seat3 = new Seat("2", 3, 2);
        seat4 = new Seat("3", 4, 2);
        seat5 = new Seat("4", 5, 3);
        seat6 = new Seat("5", 6, 4);
        seat7 = new Seat("6", 7, 1);
        seat8 = new Seat("7", 8, 1);
        seat9 = new Seat("8", 9, 1);
        seat10 = new Seat("9", 10, 1);

        seatList.add(seat1);
        seatList.add(seat2);
        seatList.add(seat3);
        seatList.add(seat4);
        seatList.add(seat5);
        seatList.add(seat6);
        seatList.add(seat7);
        seatList.add(seat8);
        seatList.add(seat9);
        seatList.add(seat10);

        steam1 = new Steam("0", 1, seatList);
        steam2 = new Steam("0", 2, seatList);
        steam3 = new Steam("0", 3, seatList);
        steam4 = new Steam("0", 4, seatList);

        steamList.add(steam1);
        steamList.add(steam2);
        steamList.add(steam3);
        steamList.add(steam4);

        LinearLayoutManager _layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(_layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        steamAdapter = new SteamerAdapter(SteamerFragment.this, steamList, onSteamerClickListener);
        recyclerView.setAdapter(steamAdapter);
        steamAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(Steamer steamer) {
        Intent intent = new Intent(getApplicationContext(), SteamerFragment.class);
        intent.putExtra("steam", steam);
        intent.putExtra("seat", seat);
        startActivity(intent);
    }
}
