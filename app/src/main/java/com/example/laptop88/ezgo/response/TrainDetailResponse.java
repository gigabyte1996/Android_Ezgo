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
    private Integer trainID;
    @SerializedName("trainName")
    @Expose
    private String trainName;

    @SerializedName("trainType")
    @Expose
    private Integer trainType;

    @SerializedName("steamerList")
    @Expose
    private List<Steamer> steamerList;

    public TrainDetailResponse() {
    }

    public Message getError() {
        return error;
    }

    public void setError(Message error) {
        this.error = error;
    }

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

    public Integer getTrainType() {
        return trainType;
    }

    public void setTrainType(Integer trainType) {
        this.trainType = trainType;
    }

    public List<Steamer> getSteamerList() {
        return steamerList;
    }

    public void setSteamerList(List<Steamer> steamerList) {
        this.steamerList = steamerList;
    }

    public TrainDetailResponse(Message error, Integer trainID, String trainName, Integer trainType, List<Steamer> steamerList) {
        this.error = error;
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
        this.steamerList = steamerList;
    }
}
