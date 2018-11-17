package com.example.laptop88.ezgo.view.activity.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment.ShowTrainDiagramFragment;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class BookingActivity extends AppCompatActivity implements BookingActivityView {
    private List<TrainSchedule> trainSchedules;
    private ShowTrainDiagramFragment mShowTrainDiagramFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_booking);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        trainSchedules = new ArrayList<>();
        trainSchedules = (List<TrainSchedule>) intent.getSerializableExtra("trainSchedule");
        Log.d("success", trainSchedules.toString());
        Fragment mFragment = new ShowTrainScheduleFragment();
        pushFragment(PushFrgType.REPLACE, mFragment, mFragment.getTag(), R.id.home_container, trainSchedules);

    }

    public void pushFragment(PushFrgType type, Fragment fragment, String tag, @IdRes int mContainerId, List<TrainSchedule> trainSchedules) {
        try {
            Bundle bundle = new Bundle();
            bundle.putSerializable("trainSchedule", (Serializable) trainSchedules);
            fragment.setArguments(bundle);
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

    public void updateSeatBookingView(String carrageId) {
        mShowTrainDiagramFragment.handleCarrageSelected(carrageId);
    }


}
