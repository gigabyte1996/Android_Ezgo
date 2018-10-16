package com.example.laptop88.ezgo.view.activity.booking;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
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

    @BindView((R.id.edtFromStation))
    EditText edtFromStation;

    @BindView(R.id.edtToStation)
    EditText edtToStation;

    @BindView(R.id.btnShowShow_Train)
    Button btnShowTrain;

    @BindView(R.id.llDate)
    LinearLayout llDate;

    @Nullable
    @BindView(R.id.datePicker)
    DatePicker datePicker;

    @BindView(R.id.txtDate)
    TextView txtDate;

    @BindView(R.id.txtSingle)
    TextView txtSingle;

    @BindView(R.id.txtReturn)
    TextView txtReturn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_train_by_station, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.llDate})
    public void getDate(View view) {
        switch (view.getId()) {
            case R.id.llDate:
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        txtDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day);
                datePickerDialog.show();
                break;
        }

    }

    @OnTextChanged({R.id.edtFromStation, R.id.edtToStation})
    protected void onTextChanged() {

        String fromStation = edtFromStation.getText().toString().trim();
        String toStation = edtToStation.getText().toString().trim();

        if (fromStation.isEmpty() || toStation.isEmpty()) {
            btnShowTrain.setEnabled(false);
        } else {
            btnShowTrain.setEnabled(true);
        }
    }

    @OnClick({R.id.txtSingle, R.id.txtReturn})
    public void getTypeOfSchedule(TextView textView) {
//        TextView textView;
        switch (textView.getId()) {
            case R.id.txtSingle: {
                if (textView.isClickable()) {
                    textView.setTextColor(getResources().getColor(R.color.colorConcepLight));

                }
            }
            case R.id.txtReturn: {

            }
        }
    }
}

