package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainScheduleFragment;

import com.example.laptop88.ezgo.response.TrainDetailResponse;

public class ShowReturnTrainScheduleFragmentPresenterImpl implements ShowReturnTrainScheduleFragmentPresenter {
    private ShowReturnTrainScheduleModel mShowReturnTrainScheduleModel;
    private ShowReturnTrainScheduleFragmentView mShowReturnTrainScheduleFragmentView;


    public ShowReturnTrainScheduleFragmentPresenterImpl(ShowReturnTrainScheduleFragmentView mShowReturnTrainScheduleFragmentView) {
        this.mShowReturnTrainScheduleFragmentView = mShowReturnTrainScheduleFragmentView;
        mShowReturnTrainScheduleModel = new ShowReturnTrainScheduleModelImpl(this);
    }

    @Override
    public void getTrainDiagramByTrainScheduleID(Integer id) {
        mShowReturnTrainScheduleFragmentView.showProgressDialog();
        mShowReturnTrainScheduleModel.getTrainDiagramByTrainScheduleID(id);
    }

    @Override
    public void getTrainDiagramByTrainScheduleIDSuccess(TrainDetailResponse trainDetailResponse) {
        mShowReturnTrainScheduleFragmentView.closeProgressDialog();
        mShowReturnTrainScheduleFragmentView.showTrainDiagram(trainDetailResponse);
    }

    @Override
    public void getTrainDiagramByTrainScheduleIDFail() {
//        mShowReturnTrainScheduleFragmentView.closeProgressDialog();
        mShowReturnTrainScheduleFragmentView.showToast("FAIL");

    }

    @Override
    public void showToast(String s) {
        mShowReturnTrainScheduleFragmentView.closeProgressDialog();
        mShowReturnTrainScheduleFragmentView.showToast(s);

    }
}
