package com.example.laptop88.ezgo.response;

import com.example.laptop88.ezgo.fragment.seat.ShowTrainFragment.SeatModel;

import java.io.Serializable;
import java.util.List;

public class Steamer implements Serializable {
    private String id;
    private int steamerNumber;
    private boolean inAvailable;
    private List<Seat> seatList;

    public Steamer() {

    }


    public Steamer(String id, int steamerNumber, List<Seat> seatList) {
        this.id = id;
        this.steamerNumber = steamerNumber;
//        this.inAvailable = inAvailable;
        this.seatList = seatList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSteamerNumber() {
        return steamerNumber;
    }

    public void setSteamerNumber(int steamerNumber) {
        this.steamerNumber = steamerNumber;
    }

    public boolean isInAvailable() {
        return inAvailable;
    }

    public void setInAvailable(boolean inAvailable) {
        this.inAvailable = inAvailable;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
