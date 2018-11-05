package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class TrainScheduleResponse {

    @SerializedName("error")
    @Expose
    private Message error;

    @SerializedName("trainSchedules")
    @Expose
    private List<TrainSchedule> trainSchedules;

    public TrainScheduleResponse(Message error, List<TrainSchedule> trainSchedules) {
        this.error = error;
        this.trainSchedules = trainSchedules;
    }

    public Message getError() {
        return error;
    }

    public void setError(Message error) {
        this.error = error;
    }

    public List<TrainSchedule> getTrainSchedules() {
        return trainSchedules;
    }

    public void setTrainSchedules(List<TrainSchedule> trainSchedules) {
        this.trainSchedules = trainSchedules;
    }
}
