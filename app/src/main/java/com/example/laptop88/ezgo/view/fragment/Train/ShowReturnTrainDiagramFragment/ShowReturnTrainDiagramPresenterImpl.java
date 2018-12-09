package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainDiagramFragment;

import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.SeatStorageResponse;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragment;

public class ShowReturnTrainDiagramPresenterImpl implements ShowReturnTrainDiagramPresenter {
    private ShowReturnTrainDiagramModel mReturnTrainDiagramModel;
    private ShowReturnTrainDiagramFragmentView mReturnTrainDiagramFragmentView;
    private SeatStorage seatStorage;

    public ShowReturnTrainDiagramPresenterImpl(ShowReturnTrainDiagramFragmentView showReturnTrainDiagramFragmentView){
        mReturnTrainDiagramFragmentView = showReturnTrainDiagramFragmentView;
        mReturnTrainDiagramModel = new ShowReturnTrainDiagramModelImpl(this);

    }


    @Override
    public void addSeatStorage(SeatStorage seatStorage) {
        mReturnTrainDiagramFragmentView.showProgressDialog();
        mReturnTrainDiagramModel.addSeatStorage(seatStorage);
    }

    @Override
    public void addSeatStorageSuccess(SeatStorageResponse seatStorageResponse) {
        mReturnTrainDiagramFragmentView.closeProgressDialog();
        mReturnTrainDiagramFragmentView.showSeatStorage(seatStorageResponse.getSeatStorageList());
    }

    @Override
    public void addSeatStorageFalse() {
        mReturnTrainDiagramFragmentView.closeProgressDialog();
        mReturnTrainDiagramFragmentView.showToast("FAIL");

    }

    @Override
    public void deleteSeatStorage(SeatStorageDeleteRequest seatStorageDeleteRequest) {
        mReturnTrainDiagramFragmentView.showProgressDialog();
        mReturnTrainDiagramModel.deleteSeatStorage(seatStorageDeleteRequest);
    }

    @Override
    public void showToast(String s) {
        mReturnTrainDiagramFragmentView.closeProgressDialog();
        mReturnTrainDiagramFragmentView.showToast(s);

    }

    @Override
    public void deleteSeatStorageSuccess(SeatStorageResponse seatStorageResponse) {
        mReturnTrainDiagramFragmentView.closeProgressDialog();
        mReturnTrainDiagramFragmentView.showSeatStorage(seatStorageResponse.getSeatStorageList());
    }

    @Override
    public void deleteSeatStorageFalse() {
        mReturnTrainDiagramFragmentView.closeProgressDialog();
        mReturnTrainDiagramFragmentView.showToast("FAIL");
    }


}
