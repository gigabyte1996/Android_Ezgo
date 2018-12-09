package com.example.laptop88.ezgo.view.fragment.seatStorage.ShowSeatStorageFragment;

import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.view.activity.main.MainScreenActivityView;

import java.util.List;

public class ShowSeatStoragePresenterImpl implements ShowSeatStoragePresenter {
    private ShowSeatStorageModel mShowSeatStorageModel;
    private ShowSeatStorageView mShowSeatStorageView;

    public ShowSeatStoragePresenterImpl(ShowSeatStorageView mShowSeatStorageView) {
        mShowSeatStorageView = mShowSeatStorageView;
        mShowSeatStorageModel = new ShowSeatStorageModelImpl(this);
    }


    @Override
    public void getSeatStorageByUserID(Integer userID) {
        mShowSeatStorageModel.getSeatStorageByUserID(userID);
    }

    @Override
    public void getSeatStorageByUserIDSuccess(List<SeatStorage> seatStorages) {
        mShowSeatStorageView.showSeatStorage(seatStorages);

    }


    @Override
    public void getSeatStorageByUserIDFalse() {
        mShowSeatStorageView.showToast("FALSE");

    }
}
