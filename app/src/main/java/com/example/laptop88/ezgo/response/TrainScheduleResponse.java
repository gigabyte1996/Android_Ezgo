package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TrainScheduleResponse implements Serializable {

    @SerializedName("error")
    @Expose
    private Message error;

    @SerializedName("singleTrainSchedules")
    @Expose
    private List<TrainSchedule> singleTrainSchedules;

    @SerializedName("returnTrainSchedules")
    @Expose
    private List<TrainSchedule> returnTrainSchedules;

    public Message getError() {
        return error;
    }

    public void setError(Message error) {
        this.error = error;
    }

    public List<TrainSchedule> getSingleTrainSchedules() {
        return singleTrainSchedules;
    }

    public void setSingleTrainSchedules(List<TrainSchedule> singleTrainSchedules) {
        this.singleTrainSchedules = singleTrainSchedules;
    }

    public List<TrainSchedule> getReturnTrainSchedules() {
        return returnTrainSchedules;
    }

    public void setReturnTrainSchedules(List<TrainSchedule> returnTrainSchedules) {
        this.returnTrainSchedules = returnTrainSchedules;
    }

    public TrainScheduleResponse(Message error, List<TrainSchedule> singleTrainSchedules, List<TrainSchedule> returnTrainSchedules) {
        this.error = error;
        this.singleTrainSchedules = singleTrainSchedules;
        this.returnTrainSchedules = returnTrainSchedules;
    }
}
