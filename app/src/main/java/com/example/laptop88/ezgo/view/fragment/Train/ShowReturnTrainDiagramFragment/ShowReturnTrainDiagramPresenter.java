package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainDiagramFragment;

import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.SeatStorageResponse;

public interface ShowReturnTrainDiagramPresenter {
    void addSeatStorage(SeatStorage seatStorage);
    void addSeatStorageSuccess(SeatStorageResponse seatStorageResponse);
    void addSeatStorageFalse();

    void showToast(String s);

    void deleteSeatStorage(SeatStorageDeleteRequest seatStorageDeleteRequest);
    void deleteSeatStorageSuccess(SeatStorageResponse seatStorageResponse);
    void deleteSeatStorageFalse();



}
