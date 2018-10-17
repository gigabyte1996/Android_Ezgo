package com.example.laptop88.ezgo.response;

public class Seat {
    private int seatNumber;
    private int seatStatus;
    private boolean isClick;

    public Seat(int seatNumber, int seatStatus) {
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
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
