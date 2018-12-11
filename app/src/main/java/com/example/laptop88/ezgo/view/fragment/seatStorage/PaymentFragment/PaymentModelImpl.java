package com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment;

import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.service.ApplicationApi;

import java.util.List;

public class PaymentModelImpl implements PaymentModel {
    private PaymentPresenter paymentPresenter;
    private ApplicationApi mApplicationApi;

    public PaymentModelImpl(PaymentPresenter paymentPresenter) {
        if (mApplicationApi == null) {
            mApplicationApi = new ApplicationApi();
        }
        paymentPresenter = paymentPresenter;
    }

    @Override
    public void sendPaymentRequest(List<Ticket> tickets) {

    }
}
