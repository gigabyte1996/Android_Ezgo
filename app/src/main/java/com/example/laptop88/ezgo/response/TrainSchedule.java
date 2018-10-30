package com.example.laptop88.ezgo.response;

import java.util.Date;

public class TrainSchedule {
    private String trainScheduleID;
    private String FirstStationID;
    private String LastStationID;
    private String trainID;
    private Date departureTime;
    private Date arrivalTime;

    public String getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(String trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public String getFirstStationID() {
        return FirstStationID;
    }

    public void setFirstStationID(String firstStationID) {
        FirstStationID = firstStationID;
    }

    public String getLastStationID() {
        return LastStationID;
    }

    public void setLastStationID(String lastStationID) {
        LastStationID = lastStationID;
    }

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public TrainSchedule(String trainScheduleID, String firstStationID, String lastStationID, String trainID, Date departureTime, Date arrivalTime) {

        this.trainScheduleID = trainScheduleID;
        FirstStationID = firstStationID;
        LastStationID = lastStationID;
        this.trainID = trainID;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}
