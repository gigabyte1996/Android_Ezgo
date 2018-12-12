package com.example.laptop88.ezgo.response;

public class Passenger {
    public String passengerName;
    public String ticketType;
    public String identificationNumber;
    public String dateOfBirth;

    public Passenger() {
    }

    public Passenger(String passengerName, String ticketType, String identificationNumber, String dateOfBirth) {
        this.passengerName = passengerName;
        this.ticketType = ticketType;
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
