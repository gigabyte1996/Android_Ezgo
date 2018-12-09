package com.example.laptop88.ezgo.view.fragment.seatStorage.ShowSeatStorageFragment;

import com.example.laptop88.ezgo.response.SeatStorage;

import java.util.List;

public interface ShowSeatStoragePresenter {
    void getSeatStorageByUserID(Integer userID);
    void getSeatStorageByUserIDSuccess(List<SeatStorage> seatStorages);
    void getSeatStorageByUserIDFalse();
}
