package com.example.laptop88.ezgo.view.activity.ShowListTrain;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.view.activity.booking.FindTrainByStationActivity;

/**
 * Created by Welcome on 8/28/2016.
 */
public class ShowListTrainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.list_trains);
                Intent intent = getIntent();
                if (intent != null) {
                        Bundle bundle = intent.getBundleExtra(FindTrainByStationActivity.BUNDLE);
                        if (bundle != null) {
                                System.out.println("Vy HO Title: " +bundle.getString(FindTrainByStationActivity.TITLE));
                                System.out.println("Vy HO description: " +bundle.getString(FindTrainByStationActivity.DESCRIPTION));
                        } else {
                                System.out.println("CON QUY VY Title" + intent.getStringExtra(FindTrainByStationActivity.TITLE));
                                System.out.println("CON QUY VY DESCRIPTION" + intent.getStringExtra(FindTrainByStationActivity.DESCRIPTION));
                        }
                }
        }
}