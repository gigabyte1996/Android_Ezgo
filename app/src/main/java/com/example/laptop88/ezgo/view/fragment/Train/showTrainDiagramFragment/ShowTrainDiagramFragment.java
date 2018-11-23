package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.view.EzgoApplication;
import com.example.laptop88.ezgo.view.fragment.Steamer.ShowListSteamersDiagram.CarrageListFragment;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.SeatItemAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.SteamerItemAdapter;
import com.example.laptop88.ezgo.view.fragment.seat.SeatDiagram.SeatDiagramFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowTrainDiagramFragment extends Fragment  {

    private ProgressDialog mProgressDialog;
    private TrainDetailResponse trainDetailResponse;
    private SteamerItemAdapter mRcvCarrageAdapter;
    private SeatItemAdapter mRcvSeatAdapter;


    @BindView(R.id.rcvListCarrage)
    RecyclerView rcvListCarrage;

    @BindView(R.id.rcvSeatDiagram)
    RecyclerView rcvSeatDiagram;

    @BindView(R.id.spnDepatureOrReturn)
    Spinner spinner;

    private FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train_diagram, container, false);
        ButterKnife.bind(this, view);
//        handleSpinner();
        initialOnCreateCarrageRcvAdapter();
//        initialOnCreateSeatRcvAdapter();
        return view;
    }

    private void initialOnCreateCarrageRcvAdapter() {
        Bundle bundle = this.getArguments();
        trainDetailResponse = new TrainDetailResponse();
        trainDetailResponse = (TrainDetailResponse) bundle.getSerializable("trainDetailResponse");
        fragmentManager = getActivity().getSupportFragmentManager();
        mRcvCarrageAdapter = new SteamerItemAdapter(getActivity(), fragmentManager, trainDetailResponse.getSteamerList(), this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        rcvListCarrage.setLayoutManager(layoutManager);
        rcvListCarrage.setAdapter(mRcvCarrageAdapter);


    }

    public void transferDataToAdapter(List<Seat> seatList){
//        List<Seat> seats = new ArrayList<>();
//        seats.add(seat);
        mRcvSeatAdapter = new SeatItemAdapter(getActivity(), fragmentManager, seatList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        rcvSeatDiagram.setLayoutManager(gridLayoutManager);
    }


    private void initialOnCreateSeatRcvAdapter(){
        System.out.println(trainDetailResponse.getTrainID());
        Bundle bundle = this.getArguments();
        Steamer carrage = new Steamer();
        String carrageID =  bundle.getString("carrageID");
        for (Steamer carrageItem : trainDetailResponse.getSteamerList()){
            if (carrageID.equals(carrage.getSteamerID())){
                carrage = carrageItem;
            }
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mRcvSeatAdapter = new SeatItemAdapter(getActivity(), fragmentManager, carrage.getSeatList());

        if (carrage.getSteamerType()==1 || carrage.getSteamerType()==0){
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
            rcvSeatDiagram.setLayoutManager(gridLayoutManager);
            rcvSeatDiagram.setAdapter(mRcvSeatAdapter);
        }else if (carrage.getSteamerType()==2){
            for (int i = 0; i < carrage.getSeatList().size(); i++) {
                for (int j = i; j <= i; j++) {
                    if (j % 6 == 0) {
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                        layoutManager.setOrientation(LinearLayout.VERTICAL);
                    }
                }
            }
            for (int i=0; i<carrage.getSeatList().size(); i++){
                if (i%6==0){

                }
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
            }
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
            rcvSeatDiagram.setLayoutManager(gridLayoutManager);
            rcvSeatDiagram.setAdapter(mRcvSeatAdapter);
        }else if (carrage.getSteamerType()==3){
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
            rcvSeatDiagram.setLayoutManager(gridLayoutManager);
            rcvSeatDiagram.setAdapter(mRcvSeatAdapter);
        }

    }

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

    public ShowTrainDiagramFragment() {

    }

    public ProgressDialog initProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
        }
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        return mProgressDialog;
    }


//    @Override
//    public void showToast(String msg) {
//        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void showProgressDialog() {
//        ProgressDialog progressDialog = initProgressDialog();
//        progressDialog.show();
//    }
//
//    @Override
//    public void closeProgressDialog() {
//        if (mProgressDialog.isShowing())
//            mProgressDialog.dismiss();
//    }

//    @Override
//    public void showTrainDiagram(TrainDetailResponse trainDetailResponse) {
//        train = new TrainDetailResponse();
//        if (train == null) {
//            showToast("Can not find the train diagram");
//        } else {
//            train = trainDetailResponse;
//            Log.d("list", train.toString());
//        }
//    }


//    @Override
//    public void handleCarrageSelected(String carrageId) {
//        mSeatDiagramFragment.updateView(carrageId);
//        mCarrageListFragment.updateView(carrageId);
//    }
//
//interface handleCarrageListener {
//    void showListCarrage(List<Steamer> steamerList);
//}
}
