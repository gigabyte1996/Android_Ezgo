package com.example.laptop88.ezgo.response;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable {
    private Integer ticketID;
    private Integer userID;
    private String fromStation;
    private String toStation;
    private Integer trainScheduleID;
    private String trainName;
    private String departureTime;
    private Integer seatNumber;
    private Integer carrageNumber;
    private Integer carrageType;
    private String ticketType;
    private Integer fare;
    private String passengerName;
    private String identificationNumber;
    private String dateOfBirth;

    public Ticket() {
    }


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

    public Ticket(Integer ticketID, Integer userID, String fromStation, String toStation, Integer trainScheduleID, String trainName, String departureTime, Integer seatNumber, Integer carrageNumber, Integer carrageType, String ticketType, Integer fare, String passengerName, String identificationNumber, String dateOfBirth) {
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
    }
}
