package com.example.laptop88.ezgo.view.activity.ShowListTrain;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation.FindTrainByStationFragement;

/**
 * Created by Welcome on 8/28/2016.
 */
public class ShowListTrainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.list_train_schedules);
                Intent intent = getIntent();
                if (intent != null) {
                        Bundle bundle = intent.getBundleExtra(FindTrainByStationFragement.BUNDLE);
                        if (bundle != null) {
                                System.out.println("Vy HO Title: " +bundle.getString(FindTrainByStationFragement.TITLE));
                                System.out.println("Vy HO description: " +bundle.getString(FindTrainByStationFragement.DESCRIPTION));
                        } else {
                                System.out.println("CON QUY VY Title" + intent.getStringExtra(FindTrainByStationFragement.TITLE));
                                System.out.println("CON QUY VY DESCRIPTION" + intent.getStringExtra(FindTrainByStationFragement.DESCRIPTION));
                        }
                }
        }
}