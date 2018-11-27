package com.example.laptop88.ezgo.view.activity.main;

import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.response.StationResponse;

import java.util.List;

public interface MainScreenActivityPresenter {
    void getStation();
    void getStationSuccess(List<Station> stations);
    void getStationFalse();
}
