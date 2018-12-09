package com.example.laptop88.ezgo.view.fragment.seatStorage.ShowSeatStorageFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Singleton.TicketPocket;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.seatStorage.adapter.ItemSeatStorageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowSeatStorageFragment extends Fragment  {
    private ShowSeatStoragePresenterImpl showSeatStoragePresenterImpl;
    private List<SeatStorage> seatStorageList;
    private ItemSeatStorageAdapter mRcvAdapter;

    @BindView(R.id.recyclerListSeatStorage)
    RecyclerView recyclerListSeatStorage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_seat_storage, container, false);
        ButterKnife.bind(this, view);
        ((BookingActivity)getActivity()).setTitleToolBar("Ticket Pocket");

        seatStorageList = TicketPocket.getInstance().getListTicket();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mRcvAdapter = new ItemSeatStorageAdapter(getActivity(), fragmentManager, seatStorageList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerListSeatStorage.setLayoutManager(layoutManager);
        recyclerListSeatStorage.setAdapter(mRcvAdapter);
        Log.d("AAAAAAA", String.valueOf(seatStorageList.size()));

        return view;
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
