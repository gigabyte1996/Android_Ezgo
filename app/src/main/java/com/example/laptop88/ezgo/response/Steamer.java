package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Steamer implements Serializable {
    @SerializedName("steamerID")
    @Expose
    private Integer steamerID;

    @SerializedName("steamerNumber")
    @Expose
    private Integer steamerNumber;

    @SerializedName("steamerType")
    @Expose
    private Integer  steamerType;

    @SerializedName("airCondition")
    @Expose
    private boolean airCondition;

    @SerializedName("seatList")
    @Expose
    private List<Seat> seatList;

    public Steamer() {

    }

    public Integer getSteamerID() {
        return steamerID;
    }

    public void setSteamerID(Integer steamerID) {
        this.steamerID = steamerID;
    }

    public Integer getSteamerNumber() {
        return steamerNumber;
    }

    public void setSteamerNumber(Integer steamerNumber) {
        this.steamerNumber = steamerNumber;
    }

    public Integer getSteamerType() {
        return steamerType;
    }

    public void setSteamerType(Integer steamerType) {
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

    public Steamer(Integer steamerID, Integer steamerNumber, Integer steamerType, boolean airCondition, List<Seat> seatList) {
        this.steamerID = steamerID;
        this.steamerNumber = steamerNumber;
        this.steamerType = steamerType;
        this.airCondition = airCondition;
        this.seatList = seatList;
    }
}
