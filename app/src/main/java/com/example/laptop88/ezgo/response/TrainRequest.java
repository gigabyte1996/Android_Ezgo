package com.example.laptop88.ezgo.response;

import java.util.Date;

public class TrainRequest {
    private String fromStation;
    private String toStation;
    private String departureTime;
//    private Date arrivalTime;


    public TrainRequest(String fromStation, String toStation, String departureTime) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
    }

    public TrainRequest() {
        super();
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
