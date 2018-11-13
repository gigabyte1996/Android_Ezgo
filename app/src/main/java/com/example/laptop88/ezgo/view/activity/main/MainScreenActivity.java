package com.example.laptop88.ezgo.view.activity.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.view.activity.booking1.FindTrainsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainScreenActivity extends AppCompatActivity {

    @BindView(R.id.booking)
    LinearLayout llBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.booking})
    public  void  onClick(View view){
        switch (view.getId()){
            case R.id.booking:
                Intent intent = new Intent(this, FindTrainsActivity.class);
                startActivity(intent);
                break;
        }
    }
}


