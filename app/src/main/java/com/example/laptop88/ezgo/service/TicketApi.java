package com.example.laptop88.ezgo.service;

import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.response.TicketDetailsResponse;
import com.example.laptop88.ezgo.response.TicketRequest;
import com.example.laptop88.ezgo.response.TicketResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TicketApi {

    @POST("/api/ticket/create")
    Call<TicketResponse> createTicket(@Body List<TicketRequest> ticketRequestList);

    @POST("/api/ticket/details")
    Call<TicketDetailsResponse> getTicketByUserID(@Body Integer ticketID);

}
