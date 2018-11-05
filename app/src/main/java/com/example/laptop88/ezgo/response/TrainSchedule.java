package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class TrainSchedule implements Serializable {

    @SerializedName("trainScheduleID")
    @Expose
    private String trainScheduleID;

    @SerializedName("trainName")
    @Expose
    private String trainName;

    @SerializedName("jouneyName")
    @Expose
    private String jouneyName;

    @SerializedName("departureTime")
    @Expose
    private Date departureTime;

    @SerializedName("arrivalTime")
    @Expose
    private Date arrivalTime;

    @SerializedName("firstStation")
    @Expose
    private String firstStation;

    @SerializedName("lastStation")
    @Expose
    private String lastStation;

    @SerializedName("trainID")
    @Expose
    private String trainID;

    public TrainSchedule() {
    }

    public TrainSchedule(String trainScheduleID,String trainName, String jouneyName, Date departureTime, Date arrivalTime, String firstStation, String lastStation, String trainID) {
        this.trainScheduleID = trainScheduleID;
        this.trainName = trainName;
        this.jouneyName = jouneyName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.firstStation = firstStation;
        this.lastStation = lastStation;
        this.trainID = trainID;
    }

    public String getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(String trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getJouneyName() {
        return jouneyName;
    }

    public void setJouneyName(String jouneyName) {
        this.jouneyName = jouneyName;
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

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }


}
