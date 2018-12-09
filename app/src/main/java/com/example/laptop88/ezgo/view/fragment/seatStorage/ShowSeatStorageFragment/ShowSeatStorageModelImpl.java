package com.example.laptop88.ezgo.view.fragment.seatStorage.ShowSeatStorageFragment;

import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageResponse;
import com.example.laptop88.ezgo.response.StationResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.SeatStorageApi;
import com.example.laptop88.ezgo.service.StationApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowSeatStorageModelImpl implements ShowSeatStorageModel {

    private ShowSeatStoragePresenter mShowSeatStoragePresenter;
    private ApplicationApi mApplicationApi;

    public ShowSeatStorageModelImpl(ShowSeatStoragePresenter mShowSeatStoragePresenter) {
        if (mApplicationApi == null){
            mApplicationApi = new ApplicationApi();
        }
        mShowSeatStoragePresenter = mShowSeatStoragePresenter;
    }
    @Override
    public void getSeatStorageByUserID(Integer userID) {
        mApplicationApi.getClient().create(SeatStorageApi.class).getSeatStorageByUserID(userID).enqueue(new Callback<SeatStorageResponse>() {
            @Override
            public void onResponse(Call<SeatStorageResponse> call, Response<SeatStorageResponse> response) {
                if(response.isSuccessful()) {
                    SeatStorageResponse seatStorageResponse = response.body();
                    List<SeatStorage> list = new ArrayList<>();
                    list = seatStorageResponse.getSeatStorageList();
                    mShowSeatStoragePresenter.getSeatStorageByUserIDSuccess(list);
                }
                else {
                    mShowSeatStoragePresenter.getSeatStorageByUserIDFalse();
                }
            }
            @Override
            public void onFailure(Call<SeatStorageResponse> call, Throwable t) {
                mShowSeatStoragePresenter.getSeatStorageByUserIDFalse();
            }
        });

    }
}
