package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TrainDetailResponse implements Serializable {
    @SerializedName("error")
    @Expose
    private Message error;

    @SerializedName("trainID")
    @Expose
    private String trainID;
    @SerializedName("trainName")
    @Expose
    private String trainName;

    @SerializedName("trainType")
    @Expose
    private int trainType;

    @SerializedName("steamerList")
    @Expose
    private List<Steamer> steamerList;

    public TrainDetailResponse() {
    }

    public TrainDetailResponse(Message error, String trainID, String trainName, int trainType, List<Steamer> steamerList) {
        this.error = error;
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
        this.steamerList = steamerList;
    }

    public Message getError() {
        return error;
    }

    public void setError(Message error) {
        this.error = error;
    }

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

    public List<Steamer> getSteamerList() {
        return steamerList;
    }

    public void setSteamerList(List<Steamer> steamerList) {
        this.steamerList = steamerList;
    }
}
