package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StationPerJourney implements Serializable {

    @SerializedName("stationPerJourneyID")
    @Expose
    private Integer stationPerJourneyID;

    @SerializedName("station")
    @Expose
    private String station;

    @SerializedName("trainScheduleID")
    @Expose
    private Integer trainScheduleID;

    @SerializedName("arrivalTime")
    @Expose
    private String arrivalTime;

    @SerializedName("departureTime")
    @Expose
    private String departureTime;

    public Integer getStationPerJourneyID() {
        return stationPerJourneyID;
    }

    public void setStationPerJourneyID(Integer stationPerJourneyID) {
        this.stationPerJourneyID = stationPerJourneyID;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Integer getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(Integer trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
