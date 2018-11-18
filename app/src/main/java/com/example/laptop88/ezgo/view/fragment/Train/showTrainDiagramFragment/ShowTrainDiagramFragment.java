package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;

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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.response.Train;
import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Steamer.ShowListSteamersDiagram.CarrageListFragment;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.RecyclerViewSteamerItemAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragmentView;
import com.example.laptop88.ezgo.view.fragment.seat.SeatDiagram.SeatDiagramFragment;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowTrainDiagramFragment extends Fragment  {

    private ProgressDialog mProgressDialog;
    private TrainDetailResponse trainDetailResponse;
    private RecyclerViewSteamerItemAdapter mRcvAdapter;

    private SeatDiagramFragment mSeatDiagramFragment;
    private CarrageListFragment mCarrageListFragment;

    @BindView(R.id.recyclerListCarrage)
    RecyclerView recyclerListCarrage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train_diagram, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = this.getArguments();
        trainDetailResponse = new TrainDetailResponse();
        trainDetailResponse = (TrainDetailResponse) bundle.getSerializable("trainDetailResponse");
//        Log.d("listCarrage", trainDetailResponse.getSteamerList().toString());
//        showTrainDiagramPresenterImpl = new ShowTrainDiagramPresenterImpl(this);
//        showTrainDiagramPresenterImpl.getTrainDiagramByTrainID(trainDetailResponse.getTrainID());
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        mRcvAdapter = new RecyclerViewSteamerItemAdapter(getActivity(), fragmentManager, trainDetailResponse.getSteamerList());


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerListCarrage.setLayoutManager(layoutManager);
        recyclerListCarrage.setAdapter(mRcvAdapter);

//        showToast("Success");
        return view;
    }

    public ShowTrainDiagramFragment() {

    }

    public ProgressDialog initProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
        }
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        return mProgressDialog;
    }

//    @Override
//    public void showToast(String msg) {
//        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void showProgressDialog() {
//        ProgressDialog progressDialog = initProgressDialog();
//        progressDialog.show();
//    }
//
//    @Override
//    public void closeProgressDialog() {
//        if (mProgressDialog.isShowing())
//            mProgressDialog.dismiss();
//    }

//    @Override
//    public void showTrainDiagram(TrainDetailResponse trainDetailResponse) {
//        train = new TrainDetailResponse();
//        if (train == null) {
//            showToast("Can not find the train diagram");
//        } else {
//            train = trainDetailResponse;
//            Log.d("list", train.toString());
//        }
//    }


//    @Override
//    public void handleCarrageSelected(String carrageId) {
//        mSeatDiagramFragment.updateView(carrageId);
//        mCarrageListFragment.updateView(carrageId);
//    }

interface handleCarrageListener {
    void showListCarrage(List<Steamer> steamerList);
}
}
