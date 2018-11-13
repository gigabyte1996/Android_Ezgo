package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Steamer implements Serializable {
    @SerializedName("steamerID")
    @Expose
    private String steamerID;

    @SerializedName("steamerNumber")
    @Expose
    private int steamerNumber;

    @SerializedName("steamerType")
    @Expose
    private int  steamerType;

    @SerializedName("airCondition")
    @Expose
    private boolean airCondition;

    @SerializedName("seatList")
    @Expose
    private List<Seat> seatList;

    public Steamer() {

    }

    public Steamer(String steamerID, int steamerNumber, int steamerType, boolean airCondition, List<Seat> seatList) {
        this.steamerID = steamerID;
        this.steamerNumber = steamerNumber;
        this.steamerType = steamerType;
        this.airCondition = airCondition;
        this.seatList = seatList;
    }

    public String getSteamerID() {
        return steamerID;
    }

    public void setSteamerID(String steamerID) {
        this.steamerID = steamerID;
    }

    public int getSteamerNumber() {
        return steamerNumber;
    }

    public void setSteamerNumber(int steamerNumber) {
        this.steamerNumber = steamerNumber;
    }

    public int getSteamerType() {
        return steamerType;
    }

    public void setSteamerType(int steamerType) {
        this.steamerType = steamerType;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
