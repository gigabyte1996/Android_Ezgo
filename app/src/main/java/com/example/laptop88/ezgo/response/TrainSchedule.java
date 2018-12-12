package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class TrainSchedule implements Serializable {

    @SerializedName("trainScheduleID")
    @Expose
    private Integer trainScheduleID;

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

    @SerializedName("trainScheduleCode")
    @Expose
    private String trainScheduleCode;

    @SerializedName("trainID")
    @Expose
    private Integer trainID;

    public TrainSchedule() {
    }

    public Integer getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(Integer trainScheduleID) {
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

    public Integer getTrainID() {
        return trainID;
    }

    public void setTrainID(Integer trainID) {
        this.trainID = trainID;
    }

    public String getTrainScheduleCode() {
        return trainScheduleCode;
    }

    public void setTrainScheduleCode(String trainScheduleCode) {
        this.trainScheduleCode = trainScheduleCode;
    }

    public TrainSchedule(Integer trainScheduleID, String trainName, String jouneyName, Date departureTime, Date arrivalTime, String firstStation, String lastStation, String trainScheduleCode, Integer trainID) {
        this.trainScheduleID = trainScheduleID;
        this.trainName = trainName;
        this.jouneyName = jouneyName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.firstStation = firstStation;
        this.lastStation = lastStation;
        this.trainScheduleCode = trainScheduleCode;
        this.trainID = trainID;
    }
}
