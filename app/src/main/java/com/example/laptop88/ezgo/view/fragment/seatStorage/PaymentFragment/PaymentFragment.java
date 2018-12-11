package com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Ticket;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class PaymentFragment extends Fragment implements PaymentFragmentView {
    private List<Ticket> ticketList;
    private PaymentPresenterImpl mPaymentPresenterImpl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket_pocket, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = this.getArguments();
        ticketList = new ArrayList<>();
        ticketList = (List<Ticket>) bundle.getSerializable("ticketRequest");
        return view;

    }
    public void sendPaymentRequest(List<Ticket> ticketList){
        mPaymentPresenterImpl = new PaymentPresenterImpl(this);
        mPaymentPresenterImpl.sendPaymentRequest(ticketList);
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void closeProgressDialog() {

    }
}
