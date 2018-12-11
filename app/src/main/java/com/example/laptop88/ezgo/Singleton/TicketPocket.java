package com.example.laptop88.ezgo.Singleton;

import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.Ticket;

import java.util.ArrayList;
import java.util.List;
public class TicketPocket {
    public static TicketPocket ticketPocket;
    public List<SeatStorage> listTicket = new ArrayList<>();
    public Integer sumFare = 0;

    public static TicketPocket getInstance(){
        if(ticketPocket==null)
            ticketPocket = new TicketPocket();
        return  ticketPocket;
    }

    public static TicketPocket getTicketPocket() {
        return ticketPocket;
    }

    public static void setTicketPocket(TicketPocket ticketPocket) {
        TicketPocket.ticketPocket = ticketPocket;
    }

    public List<SeatStorage> getListTicket() {
        return listTicket;
    }

    public void setListTicket(List<SeatStorage> listTicket) {
        this.listTicket = listTicket;
    }

    public Integer getSumFare() {
        return sumFare;
    }

    public void setSumFare(Integer sumFare) {
        this.sumFare = sumFare;
    }
}
