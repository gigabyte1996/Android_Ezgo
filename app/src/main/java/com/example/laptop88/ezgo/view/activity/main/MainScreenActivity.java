package com.example.laptop88.ezgo.view.activity.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Singleton.TicketPocket;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.view.activity.booking1.FindTrainsActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainScreenActivity extends AppCompatActivity implements MainScreenActivityView {
    private MainScreenActivityPresenter mainScreenActivityPresenter;
    private List<Station> stationList;
    ProgressDialog mProgressDialog;
    public List<Ticket> shoppingCart;

    @BindView(R.id.booking)
    LinearLayout llBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ButterKnife.bind(this);
        mProgressDialog = new ProgressDialog(this);
    }
    @OnClick({R.id.booking})
    public  void  onClick(View view){
        switch (view.getId()){
            case R.id.booking:
                mainScreenActivityPresenter = new MainScreenActivityPresenterImpl(this);
                mainScreenActivityPresenter.getStation();
                break;
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    public ProgressDialog initProgressDialog(){
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        return mProgressDialog;
    }

    @Override
    public void showProgressDialog() {

        mProgressDialog.setMessage("loading");
        mProgressDialog.show();
    }

    @Override
    public void closeProgressDialog() {

            mProgressDialog.dismiss();
    }

    @Override
    public void getStation(List<Station> stations) {
        Toast.makeText(MainScreenActivity.this, ""+stations.size(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, FindTrainsActivity.class);
            intent.putExtra("station",(Serializable) stations);
            startActivity(intent);
        }

    @Override
    public void showSeatStorage(List<SeatStorage> seatStorages) {
        TicketPocket.getInstance().setListTicket(seatStorages);
    }
}





