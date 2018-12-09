package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainDiagramFragment;

import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;

public interface ShowReturnTrainDiagramModel {
    void addSeatStorage(SeatStorage seatStorage);
    void deleteSeatStorage(SeatStorageDeleteRequest seatStorageDeleteRequest);

}
