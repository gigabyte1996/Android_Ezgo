package com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment;

import com.example.laptop88.ezgo.response.TrainDetailResponse;

public interface ShowTrainScheduleFragmentView  {
    void showToast(String msg);
    void showProgressDialog();
    void closeProgressDialog();

    void showTrainDiagram(TrainDetailResponse trainDetailResponse);
}
