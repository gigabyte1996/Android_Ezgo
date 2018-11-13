package com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation;

import android.content.Intent;

import com.example.laptop88.ezgo.response.TrainRequest;
import com.example.laptop88.ezgo.response.TrainScheduleResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.TrainApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindTrainByStationModelImpl implements FindTrainByStationModel {
    private FindTrainByStationFragmentPresenter mFindTrainByStationFragmentPresenter;
    private ApplicationApi mApplicationApi;

    public FindTrainByStationModelImpl(FindTrainByStationFragmentPresenter findTrainByStationFragmentPresenter) {
        if (mApplicationApi == null) {
            mApplicationApi = new ApplicationApi();
        }
        mFindTrainByStationFragmentPresenter = findTrainByStationFragmentPresenter;
    }


    @Override
    public void searchTrain(TrainRequest requestTrain) {
        Call<TrainScheduleResponse> call = mApplicationApi.getClient().create(TrainApi.class).searchTrain(requestTrain);
        call.enqueue(new Callback<TrainScheduleResponse>() {
            @Override
            public void onResponse(Call<TrainScheduleResponse> call, Response<TrainScheduleResponse> response) {
                TrainScheduleResponse trainScheduleResponse = response.body();
                int code = Integer.parseInt(trainScheduleResponse.getError().getCode());
                switch (code) {
                    case 0:
                        mFindTrainByStationFragmentPresenter.searchTrainSuccess(trainScheduleResponse.getTrainSchedules());

                        break;
                    default:
                        mFindTrainByStationFragmentPresenter.searchTrainFalse();
                        break;
                }
            }

            @Override
            public void onFailure(Call<TrainScheduleResponse> call, Throwable t) {
                mFindTrainByStationFragmentPresenter.searchTrainFalse();
            }
        });
    }
}
