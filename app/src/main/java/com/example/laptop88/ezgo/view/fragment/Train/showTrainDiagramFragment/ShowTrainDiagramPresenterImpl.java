package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;

import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.SeatStorageResponse;
import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragment;

import java.util.List;

public class ShowTrainDiagramPresenterImpl implements ShowTrainDiagramPresenter {
    private ShowTrainDiagramModel mTrainDiagramModel;
    private ShowTrainDiagramFragmentView mTrainDiagramFragmentView;
    private SeatStorage seatStorage;

    public ShowTrainDiagramPresenterImpl(ShowTrainDiagramFragmentView showTrainDiagramFragmentView){
        mTrainDiagramFragmentView = showTrainDiagramFragmentView;
        mTrainDiagramModel = new ShowTrainDiagramModelImpl(this);

    }

    public ShowTrainDiagramPresenterImpl(ShowTrainScheduleFragment showTrainScheduleFragment) {
    }

    @Override
    public void addSeatStorage(SeatStorage seatStorage) {
        mTrainDiagramFragmentView.showProgressDialog();
        mTrainDiagramModel.addSeatStorage(seatStorage);
    }



    @Override
    public void addSeatStorageSuccess(SeatStorageResponse seatStorageResponse) {
        mTrainDiagramFragmentView.closeProgressDialog();
        mTrainDiagramFragmentView.showSeatStorage(seatStorageResponse.getSeatStorageList());
    }

    @Override
    public void addSeatStorageFalse() {
        mTrainDiagramFragmentView.closeProgressDialog();
        mTrainDiagramFragmentView.showToast("FAIL");

    }

    @Override
    public void deleteSeatStorage(SeatStorageDeleteRequest seatStorageDeleteRequest) {
        mTrainDiagramFragmentView.showProgressDialog();
        mTrainDiagramModel.deleteSeatStorage(seatStorageDeleteRequest);
    }

    @Override
    public void showToast(String s) {
        mTrainDiagramFragmentView.closeProgressDialog();
        mTrainDiagramFragmentView.showToast(s);

    }

    @Override
    public void deleteSeatStorageSuccess(SeatStorageResponse seatStorageResponse) {
        mTrainDiagramFragmentView.closeProgressDialog();
        mTrainDiagramFragmentView.showSeatStorage(seatStorageResponse.getSeatStorageList());

    }

    @Override
    public void deleteSeatStorageFalse() {
        mTrainDiagramFragmentView.closeProgressDialog();
        mTrainDiagramFragmentView.showToast("FAIL");
    }


}
