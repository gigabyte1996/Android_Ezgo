package com.example.laptop88.ezgo.view.fragment.seatStorage.ShowSeatStorageFragment;

import com.example.laptop88.ezgo.response.SeatStorage;

import java.util.List;

public interface ShowSeatStorageView {
    void showSeatStorage(List<SeatStorage> seatStorages);
    void showToast(String msg);
}
