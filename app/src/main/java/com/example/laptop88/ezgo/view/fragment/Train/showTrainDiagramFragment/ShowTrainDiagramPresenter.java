package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;

import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.SeatStorageResponse;
import com.example.laptop88.ezgo.response.TrainDetailResponse;

import java.util.List;

public interface ShowTrainDiagramPresenter {
    void addSeatStorage(SeatStorage seatStorage);
    void addSeatStorageSuccess(SeatStorageResponse seatStorageResponse);
    void addSeatStorageFalse();

    void showToast(String s);

    void deleteSeatStorage(SeatStorageDeleteRequest seatStorageDeleteRequest);
    void deleteSeatStorageSuccess(SeatStorageResponse seatStorageResponse);
    void deleteSeatStorageFalse();



}
