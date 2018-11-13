package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Train;
import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Steamer.ShowListSteamersDiagram.CarrageListFragment;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragmentView;
import com.example.laptop88.ezgo.view.fragment.seat.SeatDiagram.SeatDiagramFragment;

import java.io.Serializable;
import java.util.List;

import butterknife.ButterKnife;

public class ShowTrainDiagramFragment extends Fragment implements ShowTrainDiagramFragmentView, OnClickCarrageListener {

    private ShowTrainDiagramPresenterImpl showTrainDiagramPresenterImpl;
    private ProgressDialog mProgressDialog;
    private TrainDetailResponse train;

    private SeatDiagramFragment mSeatDiagramFragment;
    private CarrageListFragment mCarrageListFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train_diagram, container, false);
        ButterKnife.bind(this, view);
        showTrainDiagramPresenterImpl = new ShowTrainDiagramPresenterImpl(this);
        showTrainDiagramPresenterImpl.getTrainDiagramByTrainID(train.getTrainID());
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

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
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

    @Override
    public void showTrainDiagram(TrainDetailResponse trainDetailResponse) {
        train = new TrainDetailResponse();
        if (train == null){
            showToast("Can not fint the train diagram");
        }
        else train = trainDetailResponse;
//        Intent intent = new  Intent(getActivity().getBaseContext(), BookingActivity.class);
//        intent.putExtra("trainDetail",(Serializable)train);
//        startActivity(intent);
    }

    @Override
    public void handleCarrageSelected(String carrageId) {
        mSeatDiagramFragment.updateView(carrageId);
        mCarrageListFragment.updateView(carrageId);
    }
}
