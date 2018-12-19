package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketDetailsResponse {
    @SerializedName("ticket")
    @Expose
    private Ticket ticket;

    @SerializedName("stationPerJourneys")
    @Expose
    private List<StationPerJourney> stationPerJourneys;

    @SerializedName("adminstraitor")
    @Expose
    private Adminstraitor adminstraitor;

    @SerializedName("error")
    @Expose
    private Message error;

    public TicketDetailsResponse() {
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Message getError() {
        return error;
    }

    public void setError(Message error) {
        this.error = error;
    }

    public List<StationPerJourney> getStationPerJourneys() {
        return stationPerJourneys;
    }

    public void setStationPerJourneys(List<StationPerJourney> stationPerJourneys) {
        this.stationPerJourneys = stationPerJourneys;
    }

    public Adminstraitor getAdminstraitor() {
        return adminstraitor;
    }

    public void setAdminstraitor(Adminstraitor adminstraitor) {
        this.adminstraitor = adminstraitor;
    }

    public TicketDetailsResponse(Ticket ticket, List<StationPerJourney> stationPerJourneys, Adminstraitor adminstraitor, Message error) {
        this.ticket = ticket;
        this.stationPerJourneys = stationPerJourneys;
        this.adminstraitor = adminstraitor;
        this.error = error;
    }
}
