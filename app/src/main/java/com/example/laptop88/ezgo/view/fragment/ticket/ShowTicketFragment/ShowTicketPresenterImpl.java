package com.example.laptop88.ezgo.view.fragment.ticket.ShowTicketFragment;


import com.example.laptop88.ezgo.response.TicketDetailsResponse;

public class ShowTicketPresenterImpl implements ShowTicketPresenter {
    private ShowTicketFragmentView mShowTicketFragmentView;
    private ShowTicketModel mShowTicketModel;

    public ShowTicketPresenterImpl(ShowTicketFragmentView showTicketFragmentView) {
        this.mShowTicketFragmentView = showTicketFragmentView;
        mShowTicketModel = new ShowTicketModelImpl(this);
    }

    @Override
    public void getTicketByUserIDFalse() {
        mShowTicketFragmentView.closeProgressDialog();
        mShowTicketFragmentView.showToast("FALSE");


    }

    @Override
    public void getTicketByUserIDSuccess(TicketDetailsResponse ticketDetailsResponse) {
        mShowTicketFragmentView.closeProgressDialog();
        mShowTicketFragmentView.showTicketDetails(ticketDetailsResponse);
    }

    public void getTicketByUserID(Integer ticketID) {
        mShowTicketFragmentView.showProgressDialog();
        mShowTicketModel.getTicketByUserID(ticketID);
    }
}
