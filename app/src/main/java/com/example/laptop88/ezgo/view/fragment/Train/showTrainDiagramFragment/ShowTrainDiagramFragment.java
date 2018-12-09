package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Singleton.CurrentTrainSchedule;
import com.example.laptop88.ezgo.Singleton.TicketPocket;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Seat;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.ShowReturnTrainScheduleFragment.ShowReturnTrainScheduleFragment;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.SeatItemAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.SteamerItemAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragment;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment.ShowTrainScheduleFragmentPresenterImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

public class ShowTrainDiagramFragment extends Fragment implements ShowTrainScheduleFragment.sendDataTofragment, ShowTrainDiagramFragmentView {

    private ProgressDialog mProgressDialog;
    private TrainDetailResponse trainDetailResponse;
    private TrainSchedule trainSchedule;
    private SteamerItemAdapter mRcvCarrageAdapter;
    private SeatItemAdapter mRcvSeatAdapter=null;
    private List<Seat> mListSeat;
    private ShowTrainDiagramPresenterImpl mShowTrainDiagramPresenterImpl;
    GridLayoutManager gridLayoutManager;
    List<TrainSchedule> returnTrainSchedules = new ArrayList<>();


    @BindView(R.id.rcvListCarrage)
    RecyclerView rcvListCarrage;

    @BindView(R.id.rcvSeatDiagram)
    RecyclerView rcvSeatDiagram;

    @BindView(R.id.llShowReturnTrainSchedules)
    LinearLayout showReturnSchedules;


    private FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train_diagram, container, false);

        ButterKnife.bind(this, view);
        initialOnCreateCarrageRcvAdapter();
        return view;
    }

    private void initialOnCreateCarrageRcvAdapter() {
        ((BookingActivity)getActivity()).setTitleToolBar("Show Train Diagram");
        ((BookingActivity)getActivity()).setVisiblePaymentBar(Constants.VisibilityType.VISIBLE);
        if (TicketPocket.getInstance().getListTicket() ==null){
            ((BookingActivity)getActivity()).setNumberOfTicket(0);
        }else {
            ((BookingActivity)getActivity()).setNumberOfTicket(TicketPocket.getInstance().getListTicket().size());
        }

        Bundle bundle = this.getArguments();
        trainDetailResponse = new TrainDetailResponse();
        trainDetailResponse = (TrainDetailResponse) bundle.getSerializable("trainDetailResponse");
//        trainSchedule = new TrainSchedule();
//        trainSchedule = (TrainSchedule) bundle.getSerializable("trainSchedule");
        fragmentManager = getActivity().getSupportFragmentManager();
        mRcvCarrageAdapter = new SteamerItemAdapter(getActivity(), fragmentManager, trainDetailResponse.getSteamerList(), this, trainSchedule);
        mRcvCarrageAdapter.notifyDataSetChanged();


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        rcvListCarrage.setLayoutManager(layoutManager);
        rcvListCarrage.setAdapter(mRcvCarrageAdapter);

        //set list ban dau
        CurrentTrainSchedule.getInstance().setSteamer(trainDetailResponse.getSteamerList().get(0));
        mListSeat = trainDetailResponse.getSteamerList().get(0).getSeatList();
        mRcvSeatAdapter = new SeatItemAdapter(getContext(), fragmentManager, mListSeat, this);
        gridLayoutManager = new GridLayoutManager(getContext(), 4);
        rcvSeatDiagram.setLayoutManager(gridLayoutManager);
        rcvSeatDiagram.setAdapter(mRcvSeatAdapter);
        mRcvSeatAdapter.notifyDataSetChanged();
    }


    public void transferDataToAdapter(List<Seat> seatList){
        Log.d(TAG, "transferDataToAdapter: "+ seatList.size());
        if( seatList.size()>0) {
            mRcvSeatAdapter.updateList(seatList);
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
//        mRcvSeatAdapter = new SeatItemAdapter(getActivity(), fragmentManager, carrage.getSeatList());
//
//        if (carrage.getSteamerType()==1 || carrage.getSteamerType()==0){
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
//            rcvSeatDiagram.setLayoutManager(gridLayoutManager);
//            rcvSeatDiagram.setAdapter(mRcvSeatAdapter);
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
//            rcvSeatDiagram.setAdapter(mRcvSeatAdapter);
//        }else if (carrage.getSteamerType()==3){
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
//            rcvSeatDiagram.setLayoutManager(gridLayoutManager);
//            rcvSeatDiagram.setAdapter(mRcvSeatAdapter);
//        }
//    }

    @OnClick(R.id.llShowReturnTrainSchedules)
    public void onClickShowReturnSchedules(){
         returnTrainSchedules = new ArrayList<>();
         returnTrainSchedules = CurrentTrainSchedule.getInstance().getListReturn();

        Bundle bundle = new Bundle();
        bundle.putSerializable("returnTrainDetailResponse", (Serializable) returnTrainSchedules);
        Fragment mFragment = new ShowReturnTrainScheduleFragment();
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
    @Override
    public void sendData(List<TrainSchedule> trainSchedules) {
        if (trainSchedules != null) {
//            returnTrainSchedules = trainSchedules;
        }
    }

    public void addSeat(SeatStorage seatStorage) {
        mShowTrainDiagramPresenterImpl = new ShowTrainDiagramPresenterImpl(this);
        mShowTrainDiagramPresenterImpl.addSeatStorage(seatStorage);
        if (TicketPocket.getInstance().getListTicket() ==null){
            ((BookingActivity)getActivity()).setNumberOfTicket(0);
        }else {
            ((BookingActivity)getActivity()).setNumberOfTicket(TicketPocket.getInstance().getListTicket().size());
        }
    }

    public void deleteSeat(SeatStorageDeleteRequest seatStorageDeleteRequest){
        mShowTrainDiagramPresenterImpl = new ShowTrainDiagramPresenterImpl(this);
        mShowTrainDiagramPresenterImpl.deleteSeatStorage(seatStorageDeleteRequest);
    }


//    @Override
//    public void onClickSeatListener(SeatStorage seatStorage) {
//        mShowTrainDiagramPresenterImpl = new ShowReturnTrainDiagramPresenterImpl(this);
//        mShowTrainDiagramPresenterImpl.addSeatStorage(seatStorage);
//
//    }

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
