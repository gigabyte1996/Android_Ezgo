package com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation;

import com.example.laptop88.ezgo.response.TrainRequest;
import com.example.laptop88.ezgo.response.TrainSchedule;

import java.util.List;

public interface FindTrainByStationFragmentPresenter {
    void searchTrain(TrainRequest requestTrain);
    void searchTrainSuccess(List<TrainSchedule> trainSchedules);
    void searchTrainFalse();
}
