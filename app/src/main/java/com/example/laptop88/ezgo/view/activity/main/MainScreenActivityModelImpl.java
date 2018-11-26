package com.example.laptop88.ezgo.view.activity.main;


import com.example.laptop88.ezgo.response.StationResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.StationApi;

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
        Call<StationResponse> call = mApplicationApi.getClient().create(StationApi.class).getListStation();
        call.enqueue(new Callback<StationResponse>() {
            @Override
            public void onResponse(Call<StationResponse> call, Response<StationResponse> response) {
//                StationResponse stationResponse = response.body();
//                int code = Integer.parseInt(stationResponse.getError().getCode());
//                switch (code) {
//                    case 0:
//                        mMainScreenActivityPresenter.getStationSuccess(stationResponse.getStations());
//
//                        break;
//                    default:
//                        mMainScreenActivityPresenter.getStationFalse();
//                        break;
//                }
            }

            @Override
            public void onFailure(Call<StationResponse> call, Throwable t) {
                mMainScreenActivityPresenter.getStationFalse();
            }
        });
    }
}
