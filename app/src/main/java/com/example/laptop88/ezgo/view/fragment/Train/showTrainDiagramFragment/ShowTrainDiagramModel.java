package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;

import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;

public interface ShowTrainDiagramModel {
    void addSeatStorage(SeatStorage seatStorage);
    void deleteSeatStorage(SeatStorageDeleteRequest seatStorageDeleteRequest);

}
