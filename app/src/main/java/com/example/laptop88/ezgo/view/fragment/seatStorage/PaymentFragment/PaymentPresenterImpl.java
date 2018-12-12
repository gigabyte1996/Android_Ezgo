package com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment;

import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.response.TicketRequest;
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
    public void sendPaymentRequest(List<TicketRequest> ticketRequestList) {
        mPaymentModel.sendPaymentRequest(ticketRequestList);
        mPaymentFragmentView.showProgressDialog();
    }

    @Override
    public void sendPaymentRequestDSuccess(TicketResponse ticketResponse) {
        mPaymentFragmentView.closeProgressDialog();
        mPaymentFragmentView.showTicket(ticketResponse);

    }

    @Override
    public void sendPaymentRequestFalse() {
        mPaymentFragmentView.closeProgressDialog();
        mPaymentFragmentView.showToast("FALSE");

    }

    @Override
    public void showToast(String s) {
        mPaymentFragmentView.closeProgressDialog();
        mPaymentFragmentView.showToast(s);
    }
}
