package com.example.laptop88.ezgo.response;

public class Seat {
    private int seatNumber;

    public Seat(int seatNumber, boolean b){
        this.seatNumber = seatNumber;
    }
    public int getSeatNumber(){
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }

}
