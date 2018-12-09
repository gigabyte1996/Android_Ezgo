package com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainDiagramFragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainScheduleFragment.ShowReturnTrainScheduleFragment;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.ReturnSteamerItemAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.ReturnSeatItemAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

public class ShowReturnTrainDiagramFragment extends Fragment implements ShowReturnTrainDiagramFragmentView {

    private ProgressDialog mProgressDialog;
    private TrainDetailResponse trainDetailResponse;
    private ReturnSteamerItemAdapter mRcvReturnCarrageAdapter;
    private ReturnSeatItemAdapter mRcvReturnSeatAdapter=null;
    private ShowReturnTrainDiagramPresenterImpl mShowReturnTrainDiagramPresenterImpl;
    private List<Seat> mListSeat;
    private GridLayoutManager gridLayoutManager;
    private List<TrainSchedule> returnTrainSchedules;



    @BindView(R.id.rcvListCarrage)
    RecyclerView rcvListCarrage;

    @BindView(R.id.rcvSeatDiagram)
    RecyclerView rcvSeatDiagram;




    private FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_return_train_diagram, container, false);
        ButterKnife.bind(this, view);
//        handleSpinner();
//        initialOnCreateSeatRcvAdapter();
//        data = new SeatStorage(getActivity().getApplicationContext());
//        data.clearSEAT();
        initialOnCreateCarrageRcvAdapter();
        return view;
    }

    private void initialOnCreateCarrageRcvAdapter() {
        ((BookingActivity)getActivity()).setTitleToolBar("Train Diagram");
        ((BookingActivity)getActivity()).setVisiblePaymentBar(Constants.VisibilityType.VISIBLE);
        Bundle bundle = this.getArguments();
        trainDetailResponse = new TrainDetailResponse();
        trainDetailResponse = (TrainDetailResponse) bundle.getSerializable("TrainReturnDetailResponse");
        if (trainDetailResponse != null){
            Log.d("ABCD", "initialOnCreateCarrageRcvAdapter: not null");
        }
//        data.storageDatas(trainDetailResponse);
        fragmentManager = getActivity().getSupportFragmentManager();
//        mRcvReturnCarrageAdapter = new ReturnSteamerItemAdapter(getActivity(), fragmentManager, trainDetailResponse.getSteamerList(), this);
        mRcvReturnCarrageAdapter = new ReturnSteamerItemAdapter(getActivity(), fragmentManager, trainDetailResponse.getSteamerList(),this);
        mRcvReturnCarrageAdapter.notifyDataSetChanged();


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        rcvListCarrage.setLayoutManager(layoutManager);
        rcvListCarrage.setAdapter(mRcvReturnCarrageAdapter);

        //set list ban dau
        mListSeat = trainDetailResponse.getSteamerList().get(0).getSeatList();
//        mListSeat = data.loadDatas().getSteamerList().get(0).getSeatList();
        mRcvReturnSeatAdapter = new ReturnSeatItemAdapter(getContext(), fragmentManager, mListSeat,this);
        gridLayoutManager = new GridLayoutManager(getContext(), 4);
        rcvSeatDiagram.setLayoutManager(gridLayoutManager);
        rcvSeatDiagram.setAdapter(mRcvReturnSeatAdapter);
        mRcvReturnSeatAdapter.notifyDataSetChanged();

    }


    public void transferDataToAdapter(List<Seat> seatList){
        Log.d(TAG, "transferDataToAdapter: "+ seatList.size());
        if( seatList.size()>0) {
            mRcvReturnSeatAdapter.updateList(seatList);
        }
        else Toast.makeText(getActivity(), "Không có ghế", Toast.LENGTH_SHORT).show();

    }


//    private void initialOnCreateSeatRcvAdapter(){
//        System.out.println(trainDetailResponse.getTrainID());
//        Bundle bundle = this.getArguments();
//        Steamer carrage = new Steamer();
//        String carrageID =  bundle.getString("carrageID");
//        for (Steamer carrageItem : trainDetailResponse.getSteamerList()){
//            if (carrageID.equals(carrage.getSteamerID())){
//                carrage = carrageItem;
//            }
//        }
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        mRcvReturnSeatAdapter = new ReturnSeatItemAdapter(getActivity(), fragmentManager, carrage.getSeatList(),null);
//
//        if (carrage.getSteamerType()==1 || carrage.getSteamerType()==0){
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
//            rcvSeatDiagram.setLayoutManager(gridLayoutManager);
//            rcvSeatDiagram.setAdapter(mRcvReturnSeatAdapter);
//        }else if (carrage.getSteamerType()==2){
//            for (int i = 0; i < carrage.getSeatList().size(); i++) {
//                for (int j = i; j <= i; j++) {
//                    if (j % 6 == 0) {
//                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
//                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//                        layoutManager.setOrientation(LinearLayout.VERTICAL);
//                    }
//                }
//            }
//            for (int i=0; i<carrage.getSeatList().size(); i++){
//                if (i%6==0){
//
//                }
//                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
//            }
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
//            rcvSeatDiagram.setLayoutManager(gridLayoutManager);
//            rcvSeatDiagram.setAdapter(mRcvReturnSeatAdapter);
//        }else if (carrage.getSteamerType()==3){
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
//            rcvSeatDiagram.setLayoutManager(gridLayoutManager);
//            rcvSeatDiagram.setAdapter(mRcvReturnSeatAdapter);
//        }
//    }


//
//    private void handleSpinner(List<Steamer> steamerList) {
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(EzgoApplication.getInstance(), R.array.planets_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                switch (String.valueOf(spinner.getSelectedItem())){
//
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//        spinner.setAdapter(adapter);
//    }


    public ShowReturnTrainDiagramFragment() {
    }


    public void addSeat(SeatStorage seatStorage) {
        mShowReturnTrainDiagramPresenterImpl = new ShowReturnTrainDiagramPresenterImpl(this);
        mShowReturnTrainDiagramPresenterImpl.addSeatStorage(seatStorage);
        if (TicketPocket.getInstance().getListTicket() ==null){
            ((BookingActivity)getActivity()).setNumberOfTicket(0);
        }else {
            ((BookingActivity)getActivity()).setNumberOfTicket(TicketPocket.getInstance().getListTicket().size());
        }
    }

    public void deleteSeat(SeatStorageDeleteRequest seatStorageDeleteRequest){
        mShowReturnTrainDiagramPresenterImpl = new ShowReturnTrainDiagramPresenterImpl(this);
        mShowReturnTrainDiagramPresenterImpl.deleteSeatStorage(seatStorageDeleteRequest);
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
    public void showSeatStorage(List<SeatStorage> seatStorages) {
        TicketPocket.getInstance().setListTicket(seatStorages);
        if (TicketPocket.getInstance().getListTicket() ==null){
            ((BookingActivity)getActivity()).setNumberOfTicket(0);
        }else {
            ((BookingActivity)getActivity()).setNumberOfTicket(TicketPocket.getInstance().getListTicket().size());
        }
    }
}
