package com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment;

import com.example.laptop88.ezgo.response.TrainDetailResponse;

public class ShowTrainScheduleFragmentPresenterImpl implements ShowTrainScheduleFragmentPresenter {
    private ShowTrainScheduleModel mShowTrainScheduleModel;
    private ShowTrainScheduleFragmentView mShowTrainScheduleFragmentView;


    public ShowTrainScheduleFragmentPresenterImpl(ShowTrainScheduleFragmentView mShowTrainScheduleFragmentView) {
        this.mShowTrainScheduleFragmentView = mShowTrainScheduleFragmentView;
        mShowTrainScheduleModel = new ShowTrainScheduleModelImpl(this);
    }

    @Override
    public void getTrainDiagramByTrainID(Integer id) {
        mShowTrainScheduleFragmentView.showProgressDialog();
        mShowTrainScheduleModel.getTrainDiagramByTrainID(id);
    }

    @Override
    public void getTrainDiagramByTrainIDSuccess(TrainDetailResponse trainDetailResponse) {
        mShowTrainScheduleFragmentView.closeProgressDialog();
        mShowTrainScheduleFragmentView.showTrainDiagram(trainDetailResponse);
    }

    @Override
    public void getTrainDiagramByTrainIDFail() {
//        mShowTrainScheduleFragmentView.closeProgressDialog();
        mShowTrainScheduleFragmentView.showToast("FAIL");

    }

    @Override
    public void showToast(String s) {
        mShowTrainScheduleFragmentView.closeProgressDialog();
        mShowTrainScheduleFragmentView.showToast(s);

    }
}
