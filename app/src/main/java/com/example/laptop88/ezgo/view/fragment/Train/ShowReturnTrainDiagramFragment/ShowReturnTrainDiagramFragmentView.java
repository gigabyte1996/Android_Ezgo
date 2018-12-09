package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainDiagramFragment;

import com.example.laptop88.ezgo.response.SeatStorage;

import java.util.List;

public interface ShowReturnTrainDiagramFragmentView {
    void showToast(String msg);
    void showProgressDialog();
    void closeProgressDialog();
    void showSeatStorage(List<SeatStorage> seatStorages);

//    void showTrainDiagram(TrainDetailResponse trainDetailResponse);
}
