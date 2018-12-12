package com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Passenger;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.TicketRequest;
import com.example.laptop88.ezgo.response.TicketResponse;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.seatStorage.adapter.ItemSeatStorageAdapter;
import com.example.laptop88.ezgo.view.fragment.ticket.ShowTicketFragment.ShowTicketFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
//import cn.pedant.SweetAlert.SweetAlertDialog;

public class PaymentFragment extends Fragment implements PaymentFragmentView {
    private ProgressDialog mProgressDialog;
    private List<TicketRequest> ticketRequestList;
    private PaymentPresenterImpl mPaymentPresenterImpl;
    private ItemSeatStorageAdapter mItemSeatStorageAdapter;
//    private SweetAlertDialog mSweetAlertDialog;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket_pocket, container, false);
        ButterKnife.bind(this, view);
        ticketRequestList = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle = this.getArguments();
        ticketRequestList = (List<TicketRequest>) bundle.getSerializable("ticketRequestList");
        sendPaymentRequest(ticketRequestList);
        return view;

    }



    public void sendPaymentRequest(List<TicketRequest> ticketRequestList) {
        mPaymentPresenterImpl = new PaymentPresenterImpl(this);
        mPaymentPresenterImpl.sendPaymentRequest(ticketRequestList);
    }

    @Override
    public void showTicket(TicketResponse ticketResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ticketList",(Serializable) ticketResponse.getTicketList());
        ShowTicketFragment mFragment = new ShowTicketFragment();
        mFragment.setArguments(bundle);
        pushFragment(BookingActivity.PushFrgType.REPLACE, mFragment, mFragment.getTag(), R.id.home_container);
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
    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }


    public ProgressDialog initProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
        }
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        return mProgressDialog;
    }

//    public SweetAlertDialog initSweetAlertDialog(){
//        if (mSweetAlertDialog == null){
//            mSweetAlertDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE).setTitleText("Loading...").setContentText("Success!!");
//        }
//        return mSweetAlertDialog;
//    }

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
    public void showSweetAlertDialog() {
//        SweetAlertDialog sweetAlertDialog = initSweetAlertDialog();
//        sweetAlertDialog.setTitleText("Loading");
//        sweetAlertDialog.setCancelable(false);
//        sweetAlertDialog.show();
    }

    @Override
    public void closeSweetAlertDialog() {
//        if (mSweetAlertDialog.isShowing()){
//            mSweetAlertDialog.setCancelable(true);
//        }

    }
}
