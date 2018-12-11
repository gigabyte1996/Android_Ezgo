package com.example.laptop88.ezgo.response;

import java.util.List;

public class TicketResponse {
    private List<Ticket> ticketList;
    private Message message;

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public TicketResponse(List<Ticket> ticketList, Message message) {
        this.ticketList = ticketList;
        this.message = message;
    }
}
