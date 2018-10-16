package com.example.laptop88.ezgo.fragment.seat.ShowTrainFragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.fragment.seat.adapter.RecyclerViewItemSeatAdapter;
import com.example.laptop88.ezgo.response.Seat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeatFragment extends AppCompatActivity {


    private List<Seat> seats;
    private RecyclerView recyclerView;
    private RecyclerViewItemSeatAdapter adapter;

    @BindView(R.id.recyclerViewSeat)
    RecyclerView recyclerViewSeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steamer_diagram);
        ButterKnife.bind(this);
        initView();
        initData();
        initAdapter();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerViewSeat);
    }

    private void initData() {
        seats = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            seats.add(new Seat(i, false));
        }
        Log.d("sss", seats.size() + "");
    }

    private void initAdapter() {
        adapter = new RecyclerViewItemSeatAdapter(seats);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
