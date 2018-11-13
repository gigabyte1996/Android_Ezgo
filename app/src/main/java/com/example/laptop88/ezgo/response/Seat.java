package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Seat implements Serializable {
    @SerializedName("seatID")
    @Expose
    private int seatID;

    @SerializedName("seatNumber")
    @Expose
    private int seatNumber;

    @SerializedName("seatType")
    @Expose
    private int seatType;

    @SerializedName("seatStatus")
    @Expose
    private int seatStatus;


    public Seat(int seatID, int seatNumber, int seatType, int seatStatus) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatType() {
        return seatType;
    }

    public void setSeatType(int seatType) {
        this.seatType = seatType;
    }

    public int getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(int seatStatus) {
        this.seatStatus = seatStatus;
    }
}
