package com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.TrainRequest;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.FindTrainsActivity;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.RecyclerViewItemTrainScheduleAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;


public class FindTrainByStationFragement extends Fragment implements FindTrainByStationFragmentView{
//    public static final String TITLE = "title";
//    public static final String DESCRIPTION = "description";
//    public static final String BUNDLE = "bundel";

//    private EditText edtNumberOfSeat;
////    private LinearLayout llDate;
    private ProgressDialog mProgressDialog;

    private FindTrainByStationFragmentPresenterImpl findTrainByStationFragmentPresenter;


    public FindTrainByStationFragement() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @BindView((R.id.edtFromStation))
    EditText edtFromStation;

    @BindView(R.id.edtToStation)
    EditText edtToStation;

    @BindView(R.id.edtNumberOfTicket)
    EditText edtNumberOfSeat;

    @BindView(R.id.btnShow_Train)
    Button btnShowTrain;

    @BindView((R.id.llDate))
    LinearLayout llDate;

    @BindView(R.id.txtDate)
    TextView txtDate;

    @BindView(R.id.txtSingle)
    TextView txtSingle;

    @BindView(R.id.txtReturn)
    TextView txtReturn;

    @BindView((R.id.llReturnDate))
    LinearLayout llReturnDate;

//    @BindView(R.id.numberOfSeat)
//    EditText edtNumberOfSeat;

    @Nullable
    @BindView(R.id.recyclerListTrainSchedule)
    RecyclerView recyclerListTrainSchedule;

    RecyclerViewItemTrainScheduleAdapter mRcvAdapter;
    List<TrainSchedule> trainSchedules;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_train_by_station, container, false);
        edtNumberOfSeat = (EditText) view.findViewById(R.id.numberOfSeat);
        llDate = (LinearLayout) view.findViewById(R.id.llDate);
        ButterKnife.bind(this, view);
        return view;
    }
//    public  void senndDataByBundle(){
//        Intent intent new Intent(FindTrainByStationActivity.this, ShowListTrainActivity.class);
//
//        Intent intent = new Intent(ActivityA.this,ActivityB.class);
//        Bundle bundle = new Bundle();
//        bundle.putString(TITLE,edtTitle.getText().toString());
//        bundle.putString(DESCRIPTION,edtDescription.getText().toString());
//        intent.putExtra(BUNDLE,bundle);
//        startActivity(intent);
//    }


    @OnClick(R.id.btnShow_Train)
    public void onClick()
    {
        TrainRequest trainRequest = new TrainRequest();
        trainRequest.setFromStation(edtFromStation.getText().toString());
        trainRequest.setToStation(edtToStation.getText().toString());
        trainRequest.setDepartureTime(txtDate.getText().toString());
        findTrainByStationFragmentPresenter = new FindTrainByStationFragmentPresenterImpl(this);
        findTrainByStationFragmentPresenter.searchTrain(trainRequest);
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
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        calendar.set(year,month,day);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        txtDate.setText(simpleDateFormat.format(calendar.getTime()));
                        System.out.println(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day);
                datePickerDialog.show();
                break;
        }

    }

    @OnClick({R.id.txtSingle, R.id.txtReturn})
    public void getTypeOfSchedule(View view){
        switch (view.getId()){
            case R.id.txtSingle:{
                txtSingle.setTextColor(Color.WHITE);
                txtReturn.setTextColor((getResources().getColor(R.color.colorConcepLight)));
                llReturnDate.setVisibility(View.GONE);
            }
            case R.id.txtReturn:{
                txtReturn.setTextColor(Color.WHITE);
                txtSingle.setTextColor((getResources().getColor(R.color.colorConcepLight)));
                llReturnDate.setVisibility(View.VISIBLE);
            }
        }
    }

    @OnTextChanged({R.id.edtFromStation, R.id.edtToStation})
    protected void onTextChanged() {

        String fromStation = edtFromStation.getText().toString().trim();
        String toStation = edtToStation.getText().toString().trim();
      //  int numberOfSeat = Integer.parseInt(edtNumberOfSeat.getText().toString().trim());


        if (fromStation.isEmpty() || toStation.isEmpty()) {
            btnShowTrain.setEnabled(false);
        } else {
            btnShowTrain.setEnabled(true);
        }
    }

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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editTextNumberOfTicket = this.getActivity().findViewById(R.id.edtNumberOfTicket);
        editTextNumberOfTicket.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (getActivity() instanceof FindTrainsActivity) {
                    ((FindTrainsActivity)getActivity()).synchronizeTabData(s.toString());
                }
//
//                if (getActivity() instanceof ListStationActivity) {
//                    ((ListStationActivity)getActivity()).UpdateListView(s.toString());
//                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    @Override
    public void showTrain(List<TrainSchedule> trainScheduleList) {
        trainSchedules = new ArrayList<>();

        if (trainScheduleList == null){
            showToast("We couldn’t find any train");
        }else {
            trainSchedules.addAll(trainScheduleList);
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mRcvAdapter = new RecyclerViewItemTrainScheduleAdapter(getActivity(), fragmentManager, trainSchedules);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);

        recyclerListTrainSchedule.setLayoutManager(layoutManager);
        recyclerListTrainSchedule.setAdapter(mRcvAdapter);

        showToast("Success");
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }


    public ProgressDialog initProgressDialog(){
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
        }
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        return mProgressDialog;
    }

    @Override
    public void showProgressDialog() {
        ProgressDialog progressDialog = initProgressDialog();
        progressDialog.show();
    }

    @Override
    public void closeProgressDialog() {
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

}

