package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Station implements Serializable {

    @SerializedName("stationID")
    @Expose
    private String stationID;

    @SerializedName("stationName")
    @Expose
    private String stationName;

    public Station() {
    }

    public Station(String stationID, String stationName) {

        this.stationID = stationID;
        this.stationName = stationName;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
