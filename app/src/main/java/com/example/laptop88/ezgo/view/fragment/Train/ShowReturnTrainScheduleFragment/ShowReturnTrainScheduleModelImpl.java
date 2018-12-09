package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainScheduleFragment;


import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.TrainApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowReturnTrainScheduleModelImpl implements ShowReturnTrainScheduleModel {
    private ShowReturnTrainScheduleFragmentPresenter mShowReturnTrainScheduleFragmentPresenter;
    private ApplicationApi mApplicationApi;

    public ShowReturnTrainScheduleModelImpl(ShowReturnTrainScheduleFragmentPresenter showTrainDiagramFragmentPresenter) {
        if (mApplicationApi == null){
            mApplicationApi = new ApplicationApi();
        }
        mShowReturnTrainScheduleFragmentPresenter = showTrainDiagramFragmentPresenter;
    }

    @Override
    public void getTrainDiagramByTrainScheduleID(Integer trainScheduleID) {
        Call<TrainDetailResponse> call = mApplicationApi.getClient().create(TrainApi.class).getTrainDiagramByTrainScheduleID(trainScheduleID);
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
                        mShowReturnTrainScheduleFragmentPresenter.getTrainDiagramByTrainScheduleIDSuccess(trainDetailResponse);
                        break;
                    default:
                        mShowReturnTrainScheduleFragmentPresenter.getTrainDiagramByTrainScheduleIDFail();
                        break;
                }
            }
            @Override
            public void onFailure(Call<TrainDetailResponse> call, Throwable t) {
                mShowReturnTrainScheduleFragmentPresenter.getTrainDiagramByTrainScheduleIDFail();
            }
        });

    }
}
