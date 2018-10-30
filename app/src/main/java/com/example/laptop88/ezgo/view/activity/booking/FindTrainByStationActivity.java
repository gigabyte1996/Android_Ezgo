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
import com.example.laptop88.ezgo.view.activity.ShowListTrain.ShowListTrainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;


public class FindTrainByStationgi extends Fragment {
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String BUNDLE = "bundel";

    private EditText edtFromStation, edtToStation, edtNumberOfSeat;
    private Button btnShowTrain;
    private TextView txtDate;
    private LinearLayout llDate;

    public FindTrainByStationActivity() {
    }

//    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @BindView((R.id.edtFromStation))
//    EditText edtFromStation;
//
//    @BindView(R.id.edtToStation)
//    EditText edtToStation;

//    @BindView(R.id.btnShowShow_Train)
//    Button btnShowTrain;

//    @BindView(R.id.llDate)
//    LinearLayout llDate;

//    @Nullable
//    @BindView(R.id.datePicker)
//    DatePicker datePicker;
//
//    @BindView(R.id.txtDate)
//    TextView txtDate;

//    @BindView(R.id.txtSingle)
//    TextView txtSingle;
//
//    @BindView(R.id.txtReturn)
//    TextView txtReturn;

//    @BindView(R.id.numberOfSeat)
//    EditText edtNumberOfSeat;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_train_by_station, container, false);
        edtFromStation = (EditText) view.findViewById(R.id.edtFromStation);
        edtToStation = (EditText) view.findViewById(R.id.edtToStation);
        edtNumberOfSeat = (EditText) view.findViewById(R.id.numberOfSeat);
        btnShowTrain = (Button) view.findViewById(R.id.btnShow_Train);
        txtDate = (TextView) view.findViewById(R.id.txtDate);
        llDate = (LinearLayout) view.findViewById(R.id.llDate);

        llDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDatePicker();
            }
        });
        return view;
    }
    public void getDatePicker(){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(year,month,day);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                txtDate.setText(simpleDateFormat.format(calendar.getTime()));
                System.out.println(simpleDateFormat.format(calendar.getTime()));
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day);
        datePickerDialog.show();
    }
    public  void senndDataByBundle(){
        //Intent intent new Intent(FindTrainByStationActivity.this, ShowListTrainActivity.class);

//        Intent intent = new Intent(ActivityA.this,ActivityB.class);
//        Bundle bundle = new Bundle();
//        bundle.putString(TITLE,edtTitle.getText().toString());
//        bundle.putString(DESCRIPTION,edtDescription.getText().toString());
//        intent.putExtra(BUNDLE,bundle);
//        startActivity(intent);
    }



//    @OnClick({R.id.llDate})
//    public void getDate(View view) {
//        switch (view.getId()) {
//            case R.id.llDate:
//                final Calendar calendar = Calendar.getInstance();
//                int year = calendar.get(Calendar.YEAR);
//                int month = calendar.get(Calendar.MONTH);
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//                        txtDate.setText(simpleDateFormat.format(calendar));
//                    }
//                };
//                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day);
//                datePickerDialog.show();
//                break;
//        }
//
//    }

//    @OnTextChanged({R.id.edtFromStation, R.id.edtToStation, R.id.numberOfSeat})
//    protected void onTextChanged() {
//
//        String fromStation = edtFromStation.getText().toString().trim();
//        String toStation = edtToStation.getText().toString().trim();
//        int numberOfSeat = Integer.parseInt(edtNumberOfSeat.getText().toString().trim());
//
//
//        if (fromStation.isEmpty() || toStation.isEmpty()) {
//            btnShowTrain.setEnabled(false);
//        } else {
//            btnShowTrain.setEnabled(true);
//        }
//    }

//    @OnClick({R.id.txtSingle, R.id.txtReturn})
//    public void getTypeOfSchedule(TextView textView) {
////        TextView textView;
//        switch (textView.getId()) {
//            case R.id.txtSingle: {
//                if (textView.isClickable()) {
//                    textView.setTextColor(getResources().getColor(R.color.colorConcepLight));
//                    String typeOfSchedule = textView.getText().toString();
//                }
//            }
//            case R.id.txtReturn: {
//
//            }
//        }
//    }

//    @OnClick({R.id.btnShowShow_Train})
//    public void sendData(View view){
//
//        byExtra();
//    }
//
//    public void byExtra(){
//        Intent intent = new Intent(FindTrainByStationActivity.this.getActivity(), ShowListTrainActivity.class);
//        intent.putExtra(TITLE, txtDate.getText().toString());
//        intent.putExtra(DESCRIPTION, "aaaa");
//        System.out.println("button click");
//        startActivity(intent);
//    }
}

