package com.example.laptop88.ezgo.view.fragment.ticket.ShowTicketFragment;

import com.example.laptop88.ezgo.response.TicketDetailsResponse;

public interface ShowTicketPresenter {
    void getTicketByUserIDFalse();

    void getTicketByUserIDSuccess(TicketDetailsResponse ticketDetailsResponse);
}
