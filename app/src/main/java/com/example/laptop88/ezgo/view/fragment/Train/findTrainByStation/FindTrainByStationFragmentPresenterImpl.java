package com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation;

import com.example.laptop88.ezgo.response.TrainRequest;
import com.example.laptop88.ezgo.response.TrainSchedule;

import java.util.List;

public class FindTrainByStationFragmentPresenterImpl implements FindTrainByStationFragmentPresenter {

    private FindTrainByStationModel mFindTrainByStationModel;
    private FindTrainByStationFragmentView mFindTrainByStationFragmentView;

    public FindTrainByStationFragmentPresenterImpl(FindTrainByStationFragmentView findTrainByStationFragmentView) {
        mFindTrainByStationFragmentView = findTrainByStationFragmentView;
        mFindTrainByStationModel = new FindTrainByStationModelImpl(this);
    }

    @Override
    public void searchTrain(TrainRequest requestTrain) {
        mFindTrainByStationFragmentView.showProgressDialog();
        mFindTrainByStationModel.searchTrain(requestTrain);
    }

    @Override
    public void searchTrainSuccess(List<TrainSchedule> trainSchedules) {
        mFindTrainByStationFragmentView.closeProgressDialog();
        mFindTrainByStationFragmentView.showTrain(trainSchedules);
    }

    @Override
    public void searchTrainFalse() {
        mFindTrainByStationFragmentView.closeProgressDialog();
        mFindTrainByStationFragmentView.showToast("FAlSE");
    }

}
