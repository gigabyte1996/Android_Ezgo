package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainScheduleFragment;

import com.example.laptop88.ezgo.response.TrainDetailResponse;

public interface ShowReturnTrainScheduleFragmentView {
    void showToast(String msg);
    void showProgressDialog();
    void closeProgressDialog();

    void showTrainDiagram(TrainDetailResponse trainDetailResponse);
}
