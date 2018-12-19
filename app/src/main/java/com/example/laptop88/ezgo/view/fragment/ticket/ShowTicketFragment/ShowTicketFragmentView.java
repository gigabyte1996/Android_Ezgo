package com.example.laptop88.ezgo.view.fragment.ticket.ShowTicketFragment;

import com.example.laptop88.ezgo.response.TicketDetailsResponse;

public interface ShowTicketFragmentView {
    void showToast(String msg);
    void showProgressDialog();
    void closeProgressDialog();

    void showTicketDetails(TicketDetailsResponse ticketDetailsResponse);
}
