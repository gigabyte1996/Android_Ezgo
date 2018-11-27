package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class StationResponse implements Serializable {
    @SerializedName("messageResponse")
    @Expose
    private Message error;

    @SerializedName("stationList")
    @Expose
    private List<Station> stations;

    public StationResponse(Message error, List<Station> stations) {
        this.error = error;
        this.stations = stations;
    }

    public Message getError() {
        return error;
    }

    public void setError(Message error) {
        this.error = error;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
