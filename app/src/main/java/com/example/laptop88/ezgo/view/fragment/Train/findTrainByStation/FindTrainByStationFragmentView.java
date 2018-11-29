package com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation;

import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.response.TrainScheduleResponse;

import java.util.List;

public interface FindTrainByStationFragmentView {
    void showToast(String msg);
    void showProgressDialog();
    void closeProgressDialog();
    void showTrain(TrainScheduleResponse trainScheduleResponse);
}
