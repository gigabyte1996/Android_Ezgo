package com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment;

import com.example.laptop88.ezgo.response.Ticket;

import java.util.List;

public interface PaymentModel {
    void sendPaymentRequest(List<Ticket> tickets);
}
