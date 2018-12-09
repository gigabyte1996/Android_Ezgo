package com.example.laptop88.ezgo.response;

import java.util.Date;

public class Ticket {
    private Integer ticketID;
    private Integer userID;
    private Integer trainScheduleID;
    private Integer fareScheduleID;
    private String FromStation;
    private String toStation;
    private Integer scheduleTypeCode;
    private Integer trainCode;
    private Integer seatCode;
    private Integer steamerCode;
    private Integer singleOrReturn;
    private Long fare;
    private String passengerName;
    private String identificationNumber;
    private Date dateOfBirth;
    private Integer age;

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

    public Integer getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(Integer trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public Integer getFareScheduleID() {
        return fareScheduleID;
    }

    public void setFareScheduleID(Integer fareScheduleID) {
        this.fareScheduleID = fareScheduleID;
    }

    public String getFromStation() {
        return FromStation;
    }

    public void setFromStation(String fromStation) {
        FromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public Integer getScheduleTypeCode() {
        return scheduleTypeCode;
    }

    public void setScheduleTypeCode(Integer scheduleTypeCode) {
        this.scheduleTypeCode = scheduleTypeCode;
    }

    public Integer getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(Integer trainCode) {
        this.trainCode = trainCode;
    }

    public Integer getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(Integer seatCode) {
        this.seatCode = seatCode;
    }

    public Integer getSteamerCode() {
        return steamerCode;
    }

    public void setSteamerCode(Integer steamerCode) {
        this.steamerCode = steamerCode;
    }

    public Integer getSingleOrReturn() {
        return singleOrReturn;
    }

    public void setSingleOrReturn(Integer singleOrReturn) {
        this.singleOrReturn = singleOrReturn;
    }

    public Long getFare() {
        return fare;
    }

    public void setFare(Long fare) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Ticket(Integer ticketID, Integer userID, Integer trainScheduleID, Integer fareScheduleID, String fromStation, String toStation, Integer scheduleTypeCode, Integer trainCode, Integer seatCode, Integer steamerCode, Integer singleOrReturn, Long fare, String passengerName, String identificationNumber, Date dateOfBirth, Integer age) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.trainScheduleID = trainScheduleID;
        this.fareScheduleID = fareScheduleID;
        FromStation = fromStation;
        this.toStation = toStation;
        this.scheduleTypeCode = scheduleTypeCode;
        this.trainCode = trainCode;
        this.seatCode = seatCode;
        this.steamerCode = steamerCode;
        this.singleOrReturn = singleOrReturn;
        this.fare = fare;
        this.passengerName = passengerName;
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }
}
