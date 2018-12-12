package com.example.laptop88.ezgo.response;


public class TicketRequest {
    public SeatStorage seatStorage;
    public Passenger passenger;

//    public SeatStorage getSeatStorage() {
//        return seatStorage;
//    }
//
//    public void setSeatStorage(SeatStorage seatStorage) {
//        this.seatStorage = seatStorage;
//    }
//
//    public Passenger getPassenger() {
//        return passenger;
//    }
//
//    public void setPassenger(Passenger passenger) {
//        this.passenger = passenger;
//    }

    public TicketRequest(SeatStorage seatStorage, Passenger passenger) {
        this.seatStorage = seatStorage;
        this.passenger = passenger;
    }
}
