package com.example.laptop88.ezgo.response;

public class Train {
    private String trainID;
    private String trainName;
    private int trainType;

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getTrainType() {
        return trainType;
    }

    public void setTrainType(int trainType) {
        this.trainType = trainType;
    }

    public Train(String trainID, String trainName, int trainType) {

        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
    }
}
