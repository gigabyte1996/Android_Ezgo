package com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment;

//import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.RecyclerViewItemTrainScheduleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowTrainScheduleFragment extends Fragment implements ShowTrainScheduleFragmentView {
    private ProgressDialog mProgressDialog;


    @Nullable
    @BindView(R.id.recyclerListTrainSchedule)
    RecyclerView recyclerListTrainSchedule;

//    @BindView(R.id.btnBoooking)
//    LinearLayout btnBooking;

    private RecyclerViewItemTrainScheduleAdapter mRcvAdapter;
    private List<TrainSchedule> trainSchedules;

    public ShowTrainScheduleFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_train_schedules, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = this.getArguments();
        trainSchedules = new ArrayList<>();
        trainSchedules =(List<TrainSchedule>) bundle.getSerializable("trainSchedule" );
        Log.d("aaaaaaaaaaa", trainSchedules.toString());
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mRcvAdapter = new RecyclerViewItemTrainScheduleAdapter(getActivity(), fragmentManager, trainSchedules);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);

        recyclerListTrainSchedule.setLayoutManager(layoutManager);
        recyclerListTrainSchedule.setAdapter(mRcvAdapter);

        showToast("Success");
        return view;
    }
//
//    @OnClick({R.id.line})
//    public void onClick(){
//        String trainID ;
//
//    }


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
