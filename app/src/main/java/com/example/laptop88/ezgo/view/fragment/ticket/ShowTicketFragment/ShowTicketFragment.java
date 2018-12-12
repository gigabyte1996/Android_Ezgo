package com.example.laptop88.ezgo.view.fragment.ticket.ShowTicketFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.ticket.adapter.ItemTicketAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowTicketFragment extends Fragment  {
    private ItemTicketAdapter mRcvAdapter;
    private List<Ticket> tickets;

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
        mRcvAdapter = new ItemTicketAdapter(getActivity(), fragmentManager, tickets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        rcvListTicket.setLayoutManager(layoutManager);
        rcvListTicket.setAdapter(mRcvAdapter);

        return view;
    }

    public void showTicketDetail(Integer ticketID){

    }
}
