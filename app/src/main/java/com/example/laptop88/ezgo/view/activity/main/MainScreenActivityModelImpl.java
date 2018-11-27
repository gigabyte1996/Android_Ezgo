package com.example.laptop88.ezgo.view.activity.main;


import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.response.StationResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.StationApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainScreenActivityModelImpl implements MainScreenActivityModel {
    private MainScreenActivityPresenter mMainScreenActivityPresenter;
    private ApplicationApi mApplicationApi;

    public MainScreenActivityModelImpl(MainScreenActivityPresenter mainScreenActivityPresenter) {
        if (mApplicationApi == null){
            mApplicationApi = new ApplicationApi();
        }
        mMainScreenActivityPresenter = mainScreenActivityPresenter;
    }

    @Override
    public void getStation() {
       mApplicationApi.getClient().create(StationApi.class).getListStation().enqueue(new Callback<StationResponse>() {
            @Override
            public void onResponse(Call<StationResponse> call, Response<StationResponse> response) {
                if(response.isSuccessful()) {
                    StationResponse stationResponse = response.body();
                    List<Station> list = new ArrayList<>();
                    list = stationResponse.getStations();
                    mMainScreenActivityPresenter.getStationSuccess(list);
                }
                else {

                        mMainScreenActivityPresenter.getStationFalse();

                }
            }

            @Override
            public void onFailure(Call<StationResponse> call, Throwable t) {
                mMainScreenActivityPresenter.getStationFalse();
            }
        });
    }
}
