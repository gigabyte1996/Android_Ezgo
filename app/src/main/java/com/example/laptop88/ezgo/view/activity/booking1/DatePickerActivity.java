package com.example.laptop88.ezgo.view.activity.booking1;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laptop88.ezgo.R;

public class DatePickerActivity extends DialogFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.date_picker, container, false);
    }
}
