package com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Utils.ScreenUtils;
import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.response.TrainRequest;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.response.TrainScheduleResponse;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.activity.booking1.FindTrainsActivity;
import com.example.laptop88.ezgo.view.activity.main.MainScreenActivity;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.ItemStationAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.ItemTrainScheduleAdapter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;


public class FindTrainByStationFragment extends Fragment implements FindTrainByStationFragmentView {
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String BUNDLE = "bundel";

    private ProgressDialog mProgressDialog;
    private Bundle bundle;
    private List<Station> stations;
    private FindTrainByStationFragmentPresenterImpl findTrainByStationFragmentPresenterImpl;
    private ItemStationAdapter mItemStationAdapter;
    private String toStation = null;
    private String fromStation = null;
    private TrainRequest trainRequest;


    public FindTrainByStationFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @BindView((R.id.txtFromStation))
    TextView txtFromStation;

    @BindView(R.id.txtToStation)
    TextView txtToStation;

    @BindView(R.id.llFromStation)
    LinearLayout llFromStation;

    @BindView(R.id.llToStation)
    LinearLayout llToStation;

    @BindView(R.id.edtNumberOfTicket)
    EditText edtNumberOfSeat;

    @BindView(R.id.btnShow_Train)
    Button btnShowTrain;

    @BindView((R.id.llDepartureDate))
    LinearLayout llDepartureDate;

    @BindView((R.id.llReturnDate))
    LinearLayout llReturnDate;


    @BindView(R.id.txtDepartureDate)
    TextView txtDepartureDate;

    @BindView(R.id.txtReturnDate)
    TextView txtReturnDate;


    @BindView(R.id.txtSingle)
    TextView txtSingle;

    @BindView(R.id.txtReturn)
    TextView txtReturn;

    @Nullable
    @BindView(R.id.rcvListTrainSchedule)
    RecyclerView recyclerListTrainSchedule;

    ItemTrainScheduleAdapter mRcvAdapter;
    List<TrainSchedule> singleTrainSchedules;
    List<TrainSchedule> returnTrainSchedules;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_train_by_station, container, false);
        ButterKnife.bind(this, view);
        trainRequest = new TrainRequest();
        return view;

    }


    public String setPopUpAdapter(final TextView textView) {
        bundle = this.getArguments();
        stations = (List<Station>) bundle.getSerializable("station");
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("Station");
        ListView listStation = (ListView) dialog.findViewById(R.id.listStation);
        mItemStationAdapter = new ItemStationAdapter(getActivity(), R.layout.custom_dialog, stations);
        listStation.setAdapter(mItemStationAdapter);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout((int) (ScreenUtils.getWithScreen(getActivity()) * 0.7), (int) (ScreenUtils.getheightScreen(getActivity()) * 0.7));
            window.setGravity(Gravity.CENTER);
        }
        listStation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                textView.setText(stations.get(position).getStationName());
                dialog.dismiss();
            }
        });
        dialog.show();
        return String.valueOf(textView);
    }


    @OnClick(R.id.llToStation)
    public void onClickToStation() {
        toStation = setPopUpAdapter(txtToStation);

    }

    @OnClick(R.id.llFromStation)
    public void onClickFromStation() {
        fromStation = setPopUpAdapter(txtFromStation);

    }

    @OnClick(R.id.btnShow_Train)
    public void onClick() {
        if ((fromStation == null || toStation == null) || (fromStation == null && toStation == null && trainRequest.getDepartureTime() == null && trainRequest.getReturnTime() == null)) {
            btnShowTrain.setEnabled(false);
        } else if (trainRequest.getDepartureTime() == null && trainRequest.getReturnTime() == null) {
            trainRequest.setFromStation(txtToStation.getText().toString());
            trainRequest.setToStation(txtFromStation.getText().toString());
            btnShowTrain.setEnabled(true);
        } else if (trainRequest.getDepartureTime() == null && trainRequest.getReturnTime() != null) {
            trainRequest.setFromStation(txtToStation.getText().toString());
            trainRequest.setToStation(txtFromStation.getText().toString());
            trainRequest.setDepartureTime(txtReturnDate.getText().toString());
            btnShowTrain.setEnabled(true);
        } else if (trainRequest.getDepartureTime() != null && trainRequest.getReturnTime() == null) {
            trainRequest.setFromStation(txtFromStation.getText().toString());
            trainRequest.setToStation(txtToStation.getText().toString());
            trainRequest.setDepartureTime(txtDepartureDate.getText().toString());
            btnShowTrain.setEnabled(false);
        } else {
            trainRequest.setFromStation(txtFromStation.getText().toString());
            trainRequest.setToStation(txtToStation.getText().toString());
            trainRequest.setDepartureTime(txtDepartureDate.getText().toString());
            trainRequest.setReturnTime(txtReturnDate.getText().toString());
            btnShowTrain.setEnabled(false);
        }
        findTrainByStationFragmentPresenterImpl = new FindTrainByStationFragmentPresenterImpl(this);
        findTrainByStationFragmentPresenterImpl.searchTrain(trainRequest);
    }

    @OnClick({R.id.llDepartureDate})
    public void getDepatureDate(View view) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(year, month, day);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                txtDepartureDate.setText(simpleDateFormat.format(calendar.getTime()));
                System.out.println(simpleDateFormat.format(calendar.getTime()));
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day);
        trainRequest.setDepartureTime(String.valueOf(txtDepartureDate));
//        depatureDate = String.valueOf(txtDepartureDate);
        datePickerDialog.show();

    }

    @OnClick({R.id.llReturnDate})
    public void getReturnDate(View view) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(year, month, day);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                txtReturnDate.setText(simpleDateFormat.format(calendar.getTime()));
                System.out.println(simpleDateFormat.format(calendar.getTime()));
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), onDateSetListener, year, month, day);
        trainRequest.setReturnTime(String.valueOf(txtReturnDate));
//        returnDate = String.valueOf(txtReturnDate);
        datePickerDialog.show();
    }


    @OnClick({R.id.txtSingle})
    public void clickSingle(View view) {
        txtSingle.setTextColor(Color.WHITE);
        txtReturn.setTextColor((getResources().getColor(R.color.colorConcepLight)));
        llReturnDate.setVisibility(View.GONE);
    }

    @OnClick(R.id.txtReturn)
    public void clickReturn(View view) {
        txtReturn.setTextColor(Color.WHITE);
        txtSingle.setTextColor((getResources().getColor(R.color.colorConcepLight)));
        llReturnDate.setVisibility(View.VISIBLE);
    }



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


//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        EditText editTextNumberOfTicket = this.getActivity().findViewById(R.id.edtNumberOfTicket);
//        editTextNumberOfTicket.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (getActivity() instanceof FindTrainsActivity) {
//                    ((FindTrainsActivity) getActivity()).synchronizeTabData(s.toString());
//                }
////
////                if (getActivity() instanceof ListStationActivity) {
////                    ((ListStationActivity)getActivity()).UpdateListView(s.toString());
////                }
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // TODO Auto-generated method stub
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//        });
//    }

    @Override
    public void showTrain(TrainScheduleResponse trainScheduleResponse) {
        singleTrainSchedules = new ArrayList<>();
        returnTrainSchedules = new ArrayList<>();
        //
        if (trainScheduleResponse.getSingleTrainSchedules() == null) {
            showToast("We couldn’t find any train");
        } else if (trainScheduleResponse.getReturnTrainSchedules() == null){
            singleTrainSchedules.addAll(trainScheduleResponse.getSingleTrainSchedules());
            Intent intent = new Intent(getActivity().getBaseContext(), BookingActivity.class);
            intent.putExtra("trainSchedule", (Serializable) singleTrainSchedules);
            startActivity(intent);
        } else {
            singleTrainSchedules.addAll(trainScheduleResponse.getSingleTrainSchedules());
            returnTrainSchedules.addAll(trainScheduleResponse.getReturnTrainSchedules());
            Intent intent = new Intent(getActivity().getBaseContext(), BookingActivity.class);
            Log.d("ABCDE", "showTrain: not null");
            intent.putExtra("singleTrainSchedules", (Serializable) singleTrainSchedules);
            intent.putExtra("returnTrainSchedules", (Serializable) returnTrainSchedules);
            startActivity(intent);
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }


    public ProgressDialog initProgressDialog() {
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

