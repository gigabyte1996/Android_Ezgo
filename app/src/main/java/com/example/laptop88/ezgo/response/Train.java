package com.example.laptop88.ezgo.response;

public class Train {
    private Integer trainID;
    private String trainName;
    private int trainType;

    public Integer getTrainID() {
        return trainID;
    }

    public void setTrainID(Integer trainID) {
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

    public Train(Integer trainID, String trainName, int trainType) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
    }
}
