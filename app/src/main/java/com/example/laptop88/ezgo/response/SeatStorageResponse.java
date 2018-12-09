package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SeatStorageResponse implements Serializable {

    @SerializedName("error")
    @Expose
    private Message error;

    @SerializedName("seatStorageList")
    @Expose
    private List<SeatStorage> seatStorageList;


    public Message getError() {
        return error;
    }

    public void setError(Message error) {
        this.error = error;
    }

    public List<SeatStorage> getSeatStorageList() {
        return seatStorageList;
    }

    public void setSeatStorageList(List<SeatStorage> seatStorageList) {
        this.seatStorageList = seatStorageList;
    }

    public SeatStorageResponse(Message error, List<SeatStorage> seatStorageList) {
        this.error = error;
        this.seatStorageList = seatStorageList;
    }
}
