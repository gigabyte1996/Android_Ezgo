package com.example.laptop88.ezgo.view.activity.booking;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FindTrainByStationActivity extends Fragment {
    private Unbinder unbinder;
    private TextView textView;
    public FindTrainByStationActivity() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @BindView(R.id.llDate)
    LinearLayout llDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_train_by_station, container, false);
        unbinder= ButterKnife.bind(this, view);

        return view;
    }


    @OnClick({R.id.llDate})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.llDate:
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {


                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day );
                datePickerDialog.show();
               break;

        }

    }

}

