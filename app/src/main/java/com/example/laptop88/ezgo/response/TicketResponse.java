package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketResponse {
    @SerializedName("tickets")
    @Expose
    private List<Ticket> ticketList;

    @SerializedName("error")
    @Expose
    private Message error;


    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Message getError() {
        return error;
    }

    public void setError(Message error) {
        this.error = error;
    }

    public TicketResponse(List<Ticket> ticketList, Message error) {
        this.ticketList = ticketList;
        this.error = error;
    }
}
