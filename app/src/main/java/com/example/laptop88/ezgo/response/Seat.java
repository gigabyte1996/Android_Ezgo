package com.example.laptop88.ezgo.response;

import java.io.Serializable;

public class Seat implements Serializable {
    private String seatID;
    private int seatNumber;
    private int seatStatus;

    public Seat(String seatID ,int seatNumber, int seatStatus) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(int seatStatus) {
        this.seatStatus = seatStatus;
    }
}
