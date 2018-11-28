package com.example.laptop88.ezgo.response;

public class Ticket {
    private String ticketID;
    private String fareScheduleID;
    private String fromStationID;
    private String toStationID;
    private String scheduleTypeCode;
    private String trainCode;
    private String seatCode;
    private String steamerCode;
    private String singleOrReturn;
    private Long fare;
    private String passengerName;
    private String email;
    private String phoneNumber;
    private String identificationNumber;
    private int age;

    public Ticket(String ticketID, String fareScheduleID, String fromStationID, String toStationID, String scheduleTypeCode, String trainCode, String seatCode, String steamerCode, String singleOrReturn, Long fare, String passengerName, String email, String phoneNumber, String identificationNumber, int age) {
        this.ticketID = ticketID;
        this.fareScheduleID = fareScheduleID;
        this.fromStationID = fromStationID;
        this.toStationID = toStationID;
        this.scheduleTypeCode = scheduleTypeCode;
        this.trainCode = trainCode;
        this.seatCode = seatCode;
        this.steamerCode = steamerCode;
        this.singleOrReturn = singleOrReturn;
        this.fare = fare;
        this.passengerName = passengerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.identificationNumber = identificationNumber;
        this.age = age;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getFareScheduleID() {
        return fareScheduleID;
    }

    public void setFareScheduleID(String fareScheduleID) {
        this.fareScheduleID = fareScheduleID;
    }

    public String getFromStationID() {
        return fromStationID;
    }

    public void setFromStationID(String fromStationID) {
        this.fromStationID = fromStationID;
    }

    public String getToStationID() {
        return toStationID;
    }

    public void setToStationID(String toStationID) {
        this.toStationID = toStationID;
    }

    public String getScheduleTypeCode() {
        return scheduleTypeCode;
    }

    public void setScheduleTypeCode(String scheduleTypeCode) {
        this.scheduleTypeCode = scheduleTypeCode;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getSteamerCode() {
        return steamerCode;
    }

    public void setSteamerCode(String steamerCode) {
        this.steamerCode = steamerCode;
    }

    public String getSingleOrReturn() {
        return singleOrReturn;
    }

    public void setSingleOrReturn(String singleOrReturn) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
