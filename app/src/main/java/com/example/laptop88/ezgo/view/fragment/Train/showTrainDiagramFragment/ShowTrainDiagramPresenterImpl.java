//package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;
//
//import com.example.laptop88.ezgo.response.TrainDetailResponse;
//import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragment;
//
//import java.util.List;
//
//public class ShowTrainDiagramPresenterImpl implements ShowTrainDiagramPresenter {
//    private ShowTrainDiagramModel mTrainDiagramModel;
//    private ShowTrainDiagramFragmentView mTrainDiagramFragmentView;
//
//    public ShowTrainDiagramPresenterImpl(ShowTrainDiagramFragmentView showTrainDiagramFragmentView){
//        mTrainDiagramFragmentView = showTrainDiagramFragmentView;
//        mTrainDiagramModel = new ShowTrainDiagramModelImpl(this);
//
//    }
//
//    public ShowTrainDiagramPresenterImpl(ShowTrainScheduleFragment showTrainScheduleFragment) {
//    }
//
//    @Override
//    public void getTrainDiagramByTrainID(String id) {
//        mTrainDiagramFragmentView.showProgressDialog();
//        mTrainDiagramModel.getTrainDiagramByTrainID(id);
//    }
//
//    @Override
//    public void getTrainDiagramByTrainIDSuccess(TrainDetailResponse trainDetailResponse) {
//        mTrainDiagramFragmentView.closeProgressDialog();
//        mTrainDiagramFragmentView.showTrainDiagram(trainDetailResponse);
//    }
//
//    @Override
//    public void getTrainDiagramByTrainIDFail() {
//        mTrainDiagramFragmentView.closeProgressDialog();
//        mTrainDiagramFragmentView.showToast("FAIL");
//
//    }
//
//    @Override
//    public void showToast(String s) {
//        mTrainDiagramFragmentView.closeProgressDialog();
//        mTrainDiagramFragmentView.showToast(s);
//
//    }
//
//
//}
