package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private String departureTime;

    @SerializedName("arrivalTime")
    @Expose
    private String arrivalTime;

    @SerializedName("firstStation")
    @Expose
    private String firstStation;

    @SerializedName("lastStation")
    @Expose
    private String lastStation;

    @SerializedName("trainScheduleCode")
    @Expose
    private String trainScheduleCode;

    @SerializedName("administratorName")
    @Expose
    private String administratorName;

    @SerializedName("adminPhoneNumb")
    @Expose
    private String adminPhoneNumb;

    @SerializedName("stationPerJourneys")
    @Expose
    private List<StationPerJourney> stationPerJourneys;

    @SerializedName("trainID")
    @Expose
    private Integer trainID;

    public TrainSchedule() {
    }

    public List<StationPerJourney> getStationPerJourneys() {
        return stationPerJourneys;
    }

    public void setStationPerJourneys(List<StationPerJourney> stationPerJourneys) {
        this.stationPerJourneys = stationPerJourneys;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
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

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getAdminPhoneNumb() {
        return adminPhoneNumb;
    }

    public void setAdminPhoneNumb(String adminPhoneNumb) {
        this.adminPhoneNumb = adminPhoneNumb;
    }
}


