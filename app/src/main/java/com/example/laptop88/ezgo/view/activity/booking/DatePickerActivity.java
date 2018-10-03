package com.example.laptop88.ezgo.view.activity.booking;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laptop88.ezgo.R;

import butterknife.ButterKnife;

public class DatePickerActivity extends DialogFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.date_picker, container, false);
    }
}
