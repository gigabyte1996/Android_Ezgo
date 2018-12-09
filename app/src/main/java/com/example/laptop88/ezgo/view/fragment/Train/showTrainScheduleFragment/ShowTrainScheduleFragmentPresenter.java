package com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment;

import com.example.laptop88.ezgo.response.TrainDetailResponse;

public interface ShowTrainScheduleFragmentPresenter {
    void getTrainDiagramByTrainScheduleID(Integer id);
    void getTrainDiagramByTrainScheduleIDSuccess(TrainDetailResponse trainDetailResponse);
    void getTrainDiagramByTrainScheduleIDFail();
    void showToast(String s);
}
