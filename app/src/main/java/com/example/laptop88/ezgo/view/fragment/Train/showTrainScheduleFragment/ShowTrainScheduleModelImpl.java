package com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment;


import android.util.Log;

import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.TrainApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowTrainScheduleModelImpl implements ShowTrainScheduleModel {
    private ShowTrainScheduleFragmentPresenter mShowTrainScheduleFragmentPresenter;
    private ApplicationApi mApplicationApi;

    public ShowTrainScheduleModelImpl(ShowTrainScheduleFragmentPresenter showTrainDiagramFragmentPresenter) {
        if (mApplicationApi == null){
            mApplicationApi = new ApplicationApi();
        }
        mShowTrainScheduleFragmentPresenter = showTrainDiagramFragmentPresenter;
    }

    @Override
    public void getTrainDiagramByTrainScheduleID(Integer trainID) {
        Call<TrainDetailResponse> call = mApplicationApi.getClient().create(TrainApi.class).getTrainDiagramByTrainScheduleID(trainID);
        call.enqueue(new Callback<TrainDetailResponse>() {
            @Override
            public void onResponse(Call<TrainDetailResponse> call, Response<TrainDetailResponse> response) {
                TrainDetailResponse trainDetailResponse = response.body();
                int code = 0;
                if (trainDetailResponse != null) {
                    code = Integer.parseInt(trainDetailResponse.getError().getCode());
                }
                switch (code) {
                    case 0:
                        mShowTrainScheduleFragmentPresenter.getTrainDiagramByTrainScheduleIDSuccess(trainDetailResponse);
                        break;
                    default:
                        mShowTrainScheduleFragmentPresenter.getTrainDiagramByTrainScheduleIDFail();
                        break;
                }
            }
            @Override
            public void onFailure(Call<TrainDetailResponse> call, Throwable t) {
                mShowTrainScheduleFragmentPresenter.getTrainDiagramByTrainScheduleIDFail();
            }
        });

    }
}
