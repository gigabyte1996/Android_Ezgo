package com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment;

import com.example.laptop88.ezgo.response.TrainDetailResponse;

public interface ShowTrainScheduleFragmentPresenter {
    void getTrainDiagramByTrainID(Integer id);
    void getTrainDiagramByTrainIDSuccess(TrainDetailResponse trainDetailResponse);
    void getTrainDiagramByTrainIDFail();
    void showToast(String s);
}
