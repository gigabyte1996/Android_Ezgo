package com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment;

import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.response.TicketRequest;
import com.example.laptop88.ezgo.response.TicketResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.TicketApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentModelImpl implements PaymentModel {
    private PaymentPresenter paymentPresenter;
    private ApplicationApi mApplicationApi;

    public PaymentModelImpl(PaymentPresenter mPaymentPresenter) {
        if (mApplicationApi == null) {
            mApplicationApi = new ApplicationApi();
        }
        paymentPresenter = mPaymentPresenter;
    }

    @Override
    public void sendPaymentRequest(List<TicketRequest> ticketRequestList) {
        mApplicationApi.getClient().create(TicketApi.class).createTicket(ticketRequestList).enqueue(new Callback<TicketResponse>() {
            @Override
            public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {
                TicketResponse ticketResponse= response.body();
                int code = Integer.parseInt(ticketResponse.getError().getCode());
                switch (code){
                    case Constants.HTTPCodeResponse.SUCCESS:
                        paymentPresenter.sendPaymentRequestDSuccess(ticketResponse);
                        break;
                    default:
                        paymentPresenter.sendPaymentRequestFalse();
                        break;
                }
            }

            @Override
            public void onFailure(Call<TicketResponse> call, Throwable t) {
                paymentPresenter.sendPaymentRequestFalse();
            }
        });
    }
}
