package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable {
    @SerializedName("ticketID")
    @Expose
    private Integer ticketID;

    @SerializedName("userID")
    @Expose
    private Integer userID;

    @SerializedName("fromStation")
    @Expose
    private String fromStation;

    @SerializedName("toStation")
    @Expose
    private String toStation;

    @SerializedName("trainScheduleID")
    @Expose
    private Integer trainScheduleID;

    @SerializedName("trainName")
    @Expose
    private String trainName;

    @SerializedName("departureTime")
    @Expose
    private String departureTime;
//
//    @SerializedName("createDate")
//    @Expose
//    private Date dateCreate;

    @SerializedName("seatNumber")
    @Expose
    private Integer seatNumber;

    @SerializedName("carrageNumber")
    @Expose
    private Integer carrageNumber;

    @SerializedName("carrageType")
    @Expose
    private Integer carrageType;

    @SerializedName("ticketType")
    @Expose
    private String ticketType;

    @SerializedName("fare")
    @Expose
    private Integer fare;

    @SerializedName("passengerName")
    @Expose
    private String passengerName;

    @SerializedName("identificationNumber")
    @Expose
    private String identificationNumber;

    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;

    @SerializedName("trainScheduleCode")
    @Expose
    private String trainScheduleCode;

    @SerializedName("ticketStatus")
    @Expose
    private Integer ticketStatus;


    public Ticket() {
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTrainScheduleCode() {
        return trainScheduleCode;
    }

    public void setTrainScheduleCode(String trainScheduleCode) {
        this.trainScheduleCode = trainScheduleCode;
    }

//    public Date getDateCreate() {
//        return dateCreate;
//    }
//
//    public void setDateCreate(Date dateCreate) {
//        this.dateCreate = dateCreate;
//    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getCarrageNumber() {
        return carrageNumber;
    }

    public void setCarrageNumber(Integer carrageNumber) {
        this.carrageNumber = carrageNumber;
    }

    public Integer getCarrageType() {
        return carrageType;
    }

    public void setCarrageType(Integer carrageType) {
        this.carrageType = carrageType;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Ticket(Integer ticketID, Integer userID, String fromStation, String toStation, Integer trainScheduleID, String trainName, String departureTime, Integer seatNumber, Integer carrageNumber, Integer carrageType, String ticketType, Integer fare, String passengerName, String identificationNumber, String dateOfBirth, String trainScheduleCode, Integer ticketStatus) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.trainScheduleID = trainScheduleID;
        this.trainName = trainName;
        this.departureTime = departureTime;
        this.seatNumber = seatNumber;
        this.carrageNumber = carrageNumber;
        this.carrageType = carrageType;
        this.ticketType = ticketType;
        this.fare = fare;
        this.passengerName = passengerName;
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
        this.trainScheduleCode = trainScheduleCode;
        this.ticketStatus = ticketStatus;
    }
}
