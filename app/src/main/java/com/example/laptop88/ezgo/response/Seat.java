package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Seat implements Serializable {
    @SerializedName("seatID")
    @Expose
    private Integer seatID;

    @SerializedName("seatNumber")
    @Expose
    private Integer seatNumber;

    @SerializedName("seatType")
    @Expose
    private Integer seatType;

    @SerializedName("seatStatus")
    @Expose
    private Integer seatStatus;

    public Integer getSeatID() {
        return seatID;
    }

    public void setSeatID(Integer seatID) {
        this.seatID = seatID;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getSeatType() {
        return seatType;
    }

    public void setSeatType(Integer seatType) {
        this.seatType = seatType;
    }

    public Integer getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(Integer seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Seat(Integer seatID, Integer seatNumber, Integer seatType, Integer seatStatus) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }
}
