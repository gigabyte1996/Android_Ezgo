package com.example.laptop88.ezgo.fragment.Steamer.ShowSteamerDiagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.fragment.Steamer.Adapter.SteamerAdapter;
import com.example.laptop88.ezgo.fragment.seat.adapter.SeatAdapter;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.Utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class SteamerFragment extends AppCompatActivity implements onSeatClickListener {
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
    private Steamer steam1, steam2, steam3, steam4;
    private Seat seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9, seat10, seat11, seat12, seat13, seat14;
    private onSteamerClickListener onSteamerClickListener;
    private onSeatClickListener onSeatClickListener;
    private SteamerAdapter steamAdapter;
    private SeatAdapter seatAdapter;
    private EditText number;
    private int seats, seatLeft;
    private Button btn;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steamer_diagram);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewSeat);
        number = (EditText) findViewById(R.id.numberOfSeat);
        steamList = new ArrayList<>();
        seatList = new ArrayList<>();
        flag = false;
//        onSteamerClickListener = this;
        onSeatClickListener = this;
        btn = (Button) findViewById(R.id.btn);
//        Intent intent = getIntent();
//        seat = intent.getIntExtra("seat", 1);

        seat1 = new Seat("0", 1, 1);
        seat2 = new Seat("1", 2, 1);
        seat3 = new Seat("2", 3, 2);
        seat4 = new Seat("3", 4, 2);
        seat11 = new Seat("10", 11, 2);
        seat12 = new Seat("11", 12, 2);
        seat13 = new Seat("12", 13, 2);
        seat14 = new Seat("13", 14, 2);
        seat5 = new Seat("4", 5, 3);
        seat6 = new Seat("5", 6, 3);
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
        seatList.add(seat11);
        seatList.add(seat12);
        seatList.add(seat13);
        seatList.add(seat14);

        steam1 = new Steamer("0", 1, seatList);
//        steam2 = new Steamer("0", 2, seatList);
//        steam3 = new Steamer("0", 3, seatList);
//        steam4 = new Steamer("0", 4, seatList);

        steamList.add(steam1);
//        steamList.add(steam2);
//        steamList.add(steam3);
//        steamList.add(steam4);
//        recyclerView.setVisibility(View.GONE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Vui long nhap so ghe", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else {
                    seats = Integer.parseInt(number.getText().toString());
                    flag = true;
                    seatLeft = seats;
                }
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
//        LinearLayoutManager _layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        seatAdapter = new SeatAdapter(getApplicationContext(), seatList, onSeatClickListener);
        recyclerView.setAdapter(seatAdapter);
        seatAdapter.notifyDataSetChanged();

    }

//    @Override
//    public void onClick(Steamer steamer) {
////        Intent intent = new Intent(getApplicationContext(), SteamerFragment.class);
////        intent.putExtra("steam", steamer);
////        intent.putExtra("seat", seat);
////        startActivity(intent);
//    }

    @Override
    public void onClick(Seat seat) {

        if (flag) {
            if (seatLeft > 0) {
                Log.d("AAAAAA", String.valueOf(seatLeft));
                switch (seat.getSeatStatus()) {
                    case Constants.SeatStatus.EMPTY:
                        seat.setSeatStatus(Constants.SeatStatus.PICKING);
                        seatLeft = seatLeft - 1;
                        break;
                    case Constants.SeatStatus.RESERVED:
                        Toast.makeText(this, "Ghe nay da co nguoi da vui long chon ghe khac", Toast.LENGTH_SHORT).show();
                        break;
                    case Constants.SeatStatus.TRADING:
                        Toast.makeText(this, "Ghe nay dang duoc chon boi hanh khach khac vui long chon ghe khac", Toast.LENGTH_SHORT).show();
                        break;
                    case Constants.SeatStatus.PICKING:
                        seat.setSeatStatus(Constants.SeatStatus.EMPTY);
                        seatLeft = seatLeft + 1;
                        break;
                }
            } else if (seat.getSeatStatus() == 0) {
                seat.setSeatStatus(Constants.SeatStatus.EMPTY);
                seatLeft = seatLeft + 1;
            } else {
                Toast.makeText(this, "Ban khong the chon qua so ve ban da dat", Toast.LENGTH_SHORT).show();
            }
            seatAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Vui long chon so ve ban muon dat", Toast.LENGTH_SHORT).show();
        }
    }
}
