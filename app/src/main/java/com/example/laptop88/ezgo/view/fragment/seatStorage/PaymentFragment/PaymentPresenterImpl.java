package com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment;

import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.response.TicketResponse;

import java.util.List;

public class PaymentPresenterImpl implements PaymentPresenter {

    private PaymentModel mPaymentModel;
    private PaymentFragmentView mPaymentFragmentView;

    public PaymentPresenterImpl(PaymentFragmentView mPaymentFragmentView) {
        this.mPaymentFragmentView = mPaymentFragmentView;
        mPaymentModel = new PaymentModelImpl(this);
    }


    @Override
    public void sendPaymentRequest(List<Ticket> tickets) {

    }

    @Override
    public void sendPaymentRequestDSuccess(TicketResponse ticketResponse) {

    }

    @Override
    public void sendPaymentRequestFalse() {

    }

    @Override
    public void showToast(String s) {

    }
}
