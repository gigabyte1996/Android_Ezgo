package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainScheduleFragment;

import com.example.laptop88.ezgo.response.TrainDetailResponse;

public interface ShowReturnTrainScheduleFragmentPresenter {
    void getTrainDiagramByTrainScheduleID(Integer id);
    void getTrainDiagramByTrainScheduleIDSuccess(TrainDetailResponse trainDetailResponse);
    void getTrainDiagramByTrainScheduleIDFail();
    void showToast(String s);
}
