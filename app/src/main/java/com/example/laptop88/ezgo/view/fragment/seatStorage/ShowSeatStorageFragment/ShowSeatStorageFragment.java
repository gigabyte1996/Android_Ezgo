package com.example.laptop88.ezgo.view.fragment.seatStorage.ShowSeatStorageFragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Singleton.TicketPocket;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Passenger;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.response.TicketRequest;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.seatStorage.PaymentFragment.PaymentFragment;
import com.example.laptop88.ezgo.view.fragment.seatStorage.adapter.ItemSeatStorageAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowSeatStorageFragment extends Fragment {
    private ShowSeatStoragePresenterImpl showSeatStoragePresenterImpl;
    private List<SeatStorage> seatStorageList;
    private ItemSeatStorageAdapter mRcvAdapter;
    private List<Ticket> ticketList;
    private LinearLayout linearLayoutSubmit;

    @BindView(R.id.recyclerListSeatStorage)
    RecyclerView recyclerListSeatStorage;

    @BindView(R.id.btnSubmit)
    LinearLayout llSubmit;

    @BindView(R.id.txtSubmit)
    TextView txtSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_seat_storage, container, false);

        ButterKnife.bind(this, view);
        ((BookingActivity) getActivity()).setTitleToolBar("Ticket Pocket");
        ((BookingActivity) getActivity()).setVisiblePaymentBar(Constants.VisibilityType.GONE);
        String passengerObjectType[] = getResources().getStringArray(R.array.passenger_object_type);


        seatStorageList = TicketPocket.getInstance().getListTicket();
        List<Passenger> passengers = populateList(seatStorageList);
        List<TicketRequest> ticketRequests = populateTickerRequestList(seatStorageList);
        int sum = 0;
        for (SeatStorage item : seatStorageList) {
            sum += item.getFare();
        }
        TicketPocket.getInstance().setSumFare(sum);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mRcvAdapter = new ItemSeatStorageAdapter(getActivity(), fragmentManager, seatStorageList, passengerObjectType, passengers, ticketRequests);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerListSeatStorage.setLayoutManager(layoutManager);
        recyclerListSeatStorage.setAdapter(mRcvAdapter);
        Log.d("AAAAAAA", String.valueOf(seatStorageList.size()));
        txtSubmit.setText("PAY " + sum);

        return view;
    }

    private List<Passenger> populateList(List<SeatStorage> seatStorages) {

        List<Passenger> list = new ArrayList<>();
        for (int i = 0; i < seatStorages.size(); ++i) {
            list.add(new Passenger("", "", "", ""));
        }

        return list;
    }

    private List<TicketRequest> populateTickerRequestList(List<SeatStorage> seatStorages) {

        List<TicketRequest> list = new ArrayList<>();
        for (int i = 0; i < seatStorageList.size(); ++i) {
            list.add(new TicketRequest(new SeatStorage(), new Passenger()));
        }

        return list;
    }



    @OnClick(R.id.btnSubmit)
    public void sendPaymentRequest() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ticketRequestList",(Serializable) mRcvAdapter.retrieveData());
        PaymentFragment mFragment = new PaymentFragment();
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


//    public void getSeatStorageByUserID(Integer userID){
//        showSeatStoragePresenterImpl = new ShowSeatStoragePresenterImpl(this);
//        showSeatStoragePresenterImpl.getSeatStorageByUserID(userID);
//    }

//    @Override
//    public void showSeatStorage(List<SeatStorage> seatStorages) {
//
//    }
//
//    @Override
//    public void showToast(String msg) {
//
//    }
}
