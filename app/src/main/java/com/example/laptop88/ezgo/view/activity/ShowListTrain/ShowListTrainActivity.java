package com.example.laptop88.ezgo.view.activity.ShowListTrain;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation.FindTrainByStationFragment;

/**
 * Created by Welcome on 8/28/2016.
 */
public class ShowListTrainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.fragment_list_single_train_schedules);
                Intent intent = getIntent();
                if (intent != null) {
                        Bundle bundle = intent.getBundleExtra(FindTrainByStationFragment.BUNDLE);
                        if (bundle != null) {
                                System.out.println("Vy HO Title: " +bundle.getString(FindTrainByStationFragment.TITLE));
                                System.out.println("Vy HO description: " +bundle.getString(FindTrainByStationFragment.DESCRIPTION));
                        } else {
                                System.out.println("CON QUY VY Title" + intent.getStringExtra(FindTrainByStationFragment.TITLE));
                                System.out.println("CON QUY VY DESCRIPTION" + intent.getStringExtra(FindTrainByStationFragment.DESCRIPTION));
                        }
                }
        }
}