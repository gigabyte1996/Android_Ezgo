package com.example.laptop88.ezgo.view.fragment.ticket.ShowTicketFragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.response.TicketDetailsResponse;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.ticket.ShowticketDetailFragment.ShowticketDetailFragment;
import com.example.laptop88.ezgo.view.fragment.ticket.adapter.ItemTicketAdapter;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowTicketFragment extends Fragment implements ShowTicketFragmentView {
    private ItemTicketAdapter mRcvAdapter;
    private List<Ticket> tickets;
    private ShowTicketPresenterImpl mShowTicketPresenter;
    private ProgressDialog mProgressDialog;

    @BindView(R.id.rcvListTicket)
    RecyclerView rcvListTicket;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket_pocket, container, false);

        ButterKnife.bind(this, view);
        ((BookingActivity) getActivity()).setTitleToolBar("Ticket Pocket");
        ((BookingActivity) getActivity()).setVisiblePaymentBar(Constants.VisibilityType.GONE);
        Bundle bundle = this.getArguments();
        tickets = (List<Ticket>) bundle.getSerializable("ticketList");
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mRcvAdapter = new ItemTicketAdapter(getActivity(), fragmentManager, tickets, this);
//        mRcvAdapter.setCallback(new ItemTicketAdapter.setTicketCallback() {
//            @Override
//            public void getTicketByUserID(int ticketID) {
//                getTicketByUserID(ticketID);
//            }
//        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        rcvListTicket.setLayoutManager(layoutManager);
        rcvListTicket.setAdapter(mRcvAdapter);

        return view;
    }

    public ProgressDialog initProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
        }
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        return mProgressDialog;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressDialog() {
        ProgressDialog progressDialog = initProgressDialog();
        progressDialog.show();
    }

    @Override
    public void closeProgressDialog() {
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    @Override
    public void showTicketDetails(TicketDetailsResponse ticketDetailsResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ticketDetails",(Serializable) ticketDetailsResponse.getTicket());
        bundle.putSerializable("trainScheduleDetails", (Serializable) ticketDetailsResponse.getStationPerJourneys());
        bundle.putSerializable("adminstraitorInfo",  ticketDetailsResponse.getAdminstraitor());
        ShowticketDetailFragment mFragment = new ShowticketDetailFragment();
        mFragment.setArguments(bundle);
        pushFragment(BookingActivity.PushFrgType.REPLACE, mFragment, mFragment.getTag(), R.id.home_container);

    }

    public void getTicketByUserID(Integer ticketID){
//        Toast.makeText(getContext(), ""+ticketID, Toast.LENGTH_SHORT).show();
        mShowTicketPresenter = new ShowTicketPresenterImpl(this);
        mShowTicketPresenter.getTicketByUserID(ticketID);
    }


    public void pushFragment(BookingActivity.PushFrgType type, Fragment fragment, String tag, @IdRes int mContainerId) {
        try {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            if (type == BookingActivity.PushFrgType.REPLACE) {
                ft.replace(mContainerId, fragment, tag);
                ft.addToBackStack(fragment.getTag());
                ft.commitAllowingStateLoss();
            } else if (type == BookingActivity.PushFrgType.ADD) {
                ft.add(mContainerId, fragment, tag);
                ft.addToBackStack(fragment.getTag());
                ft.commit();
            }
            getFragmentManager().executePendingTransactions();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
