package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SeatStorage {
    @SerializedName("userID")
    @Expose
    private Integer userID;

    @SerializedName("trainName")
    @Expose
    private String trainName;

    @SerializedName("scheduleName")
    @Expose
    private String scheduleName;

    @SerializedName("departureTime")
    @Expose
    private String departureTime;

    @SerializedName("carrageNumber")
    @Expose
    private Integer carrageNumber;

    @SerializedName("seatStorageID")
    @Expose
    private Integer seatStorageID;

    @SerializedName("seatID")
    @Expose
    private Integer seatID;

    @SerializedName("trainScheduleID")
    @Expose
    private Integer trainScheduleID;

    @SerializedName("seatNumber")
    @Expose
    private Integer seatNumber;

    @SerializedName("carrageType")
    @Expose
    private Integer carrageType;

    @SerializedName("seatLocation")
    @Expose
    private Integer seatLocation;

    @SerializedName("fare")
    @Expose
    private Integer fare;

    @SerializedName("fromStation")
    @Expose
    private String fromStation;

    @SerializedName("toStation")
    @Expose
    private String toStation;



    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getCarrageNumber() {
        return carrageNumber;
    }

    public void setCarrageNumber(Integer carrageNumber) {
        this.carrageNumber = carrageNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getCarrageType() {
        return carrageType;
    }

    public void setCarrageType(Integer carrageType) {
        this.carrageType = carrageType;
    }

    public Integer getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(Integer seatLocation) {
        this.seatLocation = seatLocation;
    }

    public Integer getSeatStorageID() {
        return seatStorageID;
    }

    public void setSeatStorageID(Integer seatStorageID) {
        this.seatStorageID = seatStorageID;
    }

    public Integer getSeatID() {
        return seatID;
    }

    public void setSeatID(Integer seatID) {
        this.seatID = seatID;
    }

    public Integer getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(Integer trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public SeatStorage() {
    }

    public SeatStorage(Integer userID, String trainName, String scheduleName, String departureTime, Integer carrageNumber, Integer seatStorageID, Integer seatID, Integer trainScheduleID, Integer seatNumber, Integer carrageType, Integer seatLocation, Integer fare, String fromStation, String toStation) {
        this.userID = userID;
        this.trainName = trainName;
        this.scheduleName = scheduleName;
        this.departureTime = departureTime;
        this.carrageNumber = carrageNumber;
        this.seatStorageID = seatStorageID;
        this.seatID = seatID;
        this.trainScheduleID = trainScheduleID;
        this.seatNumber = seatNumber;
        this.carrageType = carrageType;
        this.seatLocation = seatLocation;
        this.fare = fare;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }
}
