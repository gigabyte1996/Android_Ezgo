package com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment;

import com.example.laptop88.ezgo.response.TicketRequest;
import com.example.laptop88.ezgo.response.TicketResponse;

import java.util.List;

public interface PaymentPresenter {
    void sendPaymentRequest(List<TicketRequest> ticketRequestList);
    void sendPaymentRequestDSuccess(TicketResponse ticketResponse);
    void sendPaymentRequestFalse();
    void showToast(String s);
}
