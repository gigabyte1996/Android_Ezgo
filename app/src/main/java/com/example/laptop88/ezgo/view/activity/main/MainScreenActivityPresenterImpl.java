package com.example.laptop88.ezgo.view.activity.main;

import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.response.StationResponse;

import java.util.List;

public class MainScreenActivityPresenterImpl implements MainScreenActivityPresenter {

    private MainScreenActivityModel mMainScreenActivityModel;
    private MainScreenActivityView mMainScreenActivityView;

    public MainScreenActivityPresenterImpl(MainScreenActivityView mMainScreenActivityView) {
        mMainScreenActivityView = mMainScreenActivityView;
        mMainScreenActivityModel = new MainScreenActivityModelImpl(this);
    }

//    @Override
//    public void getStation() {
////        mMainScreenActivityView.showProgressDialog();
////        mMainScreenActivityModel.getStation();
//
//    }

    @Override
    public void getStationSuccess(List<Station> stations) {
        mMainScreenActivityView.closeProgressDialog();
//        mMainScreenActivityView.getStation(stations);

    }

    @Override
    public void getStationFalse() {
        mMainScreenActivityView.closeProgressDialog();
        mMainScreenActivityView.showToast("FAlSE");

    }
}
