package com.example.laptop88.ezgo.view.activity.booking;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Singleton.TicketPocket;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.Utils.ScreenUtils;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.fragment.ShowTicketPocket.ShowTicketPocketFragment;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.ItemStationAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragment;
import com.example.laptop88.ezgo.view.fragment.seatStorage.ShowSeatStorageFragment.ShowSeatStorageFragment;
import com.example.laptop88.ezgo.view.fragment.seatStorage.ShowSeatStorageFragment.ShowSeatStoragePresenterImpl;
import com.example.laptop88.ezgo.view.fragment.seatStorage.adapter.ItemSeatStorageAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class BookingActivity extends AppCompatActivity  {
    private List<TrainSchedule> singleTrainSchedules;
    private List<TrainSchedule> returnTrainSchedules;
    ShowSeatStoragePresenterImpl showSeatStoragePresenterImpl;
    private ItemSeatStorageAdapter mItemSeatStorageAdapter;


    @BindView(R.id.tvTitle)
    TextView mTvTitle;

    @BindView(R.id.payment_bar)
    LinearLayout mLlPaymentBar;

    @BindView(R.id.txtNumberOfTicket)
    TextView txtNumberOfTicket;

    @BindView(R.id.llSeatStorage)
    LinearLayout llSeatStorage;

    @BindView(R.id.llPayment)
    LinearLayout llPayment;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_booking);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        singleTrainSchedules = new ArrayList<>();
        singleTrainSchedules = (List<TrainSchedule>) intent.getSerializableExtra("singleTrainSchedules");
        returnTrainSchedules = new ArrayList<>();
        returnTrainSchedules = (List<TrainSchedule>) intent.getSerializableExtra("returnTrainSchedules");
        Fragment mFragment = new ShowTrainScheduleFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("singleTrainSchedules", (Serializable) singleTrainSchedules);
        bundle.putSerializable("returnTrainSchedules", (Serializable) returnTrainSchedules);
        mFragment.setArguments(bundle);
        pushFragment(PushFrgType.REPLACE, mFragment, mFragment.getTag(), R.id.home_container);


    }

    public void pushFragment(PushFrgType type, Fragment fragment, String tag, @IdRes int mContainerId) {
        try {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            if (type == PushFrgType.REPLACE) {
                ft.replace(mContainerId, fragment, tag);
                ft.disallowAddToBackStack();
                ft.commitAllowingStateLoss();
            } else if (type == PushFrgType.ADD) {
                ft.add(mContainerId, fragment, tag);
                ft.disallowAddToBackStack();
                ft.commit();
            }
            manager.executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }



    public enum PushFrgType {
        REPLACE, ADD
    }

    public void setNumberOfTicket(Integer numberofTicket){txtNumberOfTicket.setText(String.valueOf(numberofTicket));}

    public void setTitleToolBar(String title){
        mTvTitle.setText(title);
    }

    public void setVisiblePaymentBar(int visibilityType){ mLlPaymentBar.setVisibility(visibilityType);}

//    public void setVisibleSubmitButton(int visibilityType){llSubmit.setVisibility(visibilityType);}

//    public void setTitleSubmit(String titleSubmit ){txtSubmit.setText(titleSubmit);}

    @OnClick(R.id.llSeatStorage)
    public void showSeatStorage(){
        List<SeatStorage> seatStorages = new ArrayList<>();
        seatStorages = TicketPocket.getInstance().getListTicket();

    }

    @OnClick(R.id.llPayment)
    public void showPaymentFragment(){
        Fragment mFragment = new ShowSeatStorageFragment();
        pushPaymentFragment(PushFrgType.REPLACE, mFragment, mFragment.getTag(), R.id.home_container);
    }


    public void pushPaymentFragment(PushFrgType type, Fragment fragment, String tag, @IdRes int mContainerId) {
        try {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            if (type == PushFrgType.REPLACE) {
                ft.replace(mContainerId, fragment, tag);
                ft.disallowAddToBackStack();
                ft.commitAllowingStateLoss();
            } else if (type == PushFrgType.ADD) {
                ft.add(mContainerId, fragment, tag);
                ft.disallowAddToBackStack();
                ft.commit();
            }
            manager.executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }



}
