package com.example.laptop88.ezgo.view.fragment.ticket.ShowTicketFragment;

import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.SeatStorageResponse;
import com.example.laptop88.ezgo.response.TicketDetailsResponse;
import com.example.laptop88.ezgo.service.ApplicationApi;
import com.example.laptop88.ezgo.service.SeatStorageApi;
import com.example.laptop88.ezgo.service.TicketApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowTicketModelImpl implements ShowTicketModel {
    private ApplicationApi mApplicationApi;
    private ShowTicketPresenter mShowTicketPresenter;

    public ShowTicketModelImpl(ShowTicketPresenterImpl showTicketPresenter) {
        if (mApplicationApi == null) {
            mApplicationApi = new ApplicationApi();
        }
        mShowTicketPresenter = showTicketPresenter;
    }

    @Override
    public void getTicketByUserID(Integer ticketID) {
        Call<TicketDetailsResponse> call = mApplicationApi.getClient().create(TicketApi.class).getTicketByUserID(ticketID);
        call.enqueue(new Callback<TicketDetailsResponse>() {
            @Override
            public void onResponse(Call<TicketDetailsResponse> call, Response<TicketDetailsResponse> response) {
                TicketDetailsResponse ticketDetailsResponse = response.body();
                int code = Integer.parseInt(ticketDetailsResponse.getError().getCode());

                switch (code) {
                    case Constants.HTTPCodeResponse.SUCCESS:
                        mShowTicketPresenter.getTicketByUserIDSuccess(ticketDetailsResponse);

                        break;
                    default:
                        mShowTicketPresenter.getTicketByUserIDFalse();
                        break;
                }
            }

            @Override
            public void onFailure(Call<TicketDetailsResponse> call, Throwable t) {
                mShowTicketPresenter.getTicketByUserIDFalse();
            }
        });

    }
}
