package com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment;

import com.example.laptop88.ezgo.response.TicketResponse;

public interface PaymentFragmentView {
    void showToast(String msg);
    void showProgressDialog();
    void closeProgressDialog();

    void showSweetAlertDialog();
    void closeSweetAlertDialog();

    void showTicket(TicketResponse ticketResponse);
}
