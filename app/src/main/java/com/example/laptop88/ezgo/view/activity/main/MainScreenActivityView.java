package com.example.laptop88.ezgo.view.activity.main;

import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.response.StationResponse;

import java.util.List;

public interface MainScreenActivityView {
    void showToast(String msg);
    void showProgressDialog();
    void closeProgressDialog();
//    void getStation(List<Station> stations);
}
