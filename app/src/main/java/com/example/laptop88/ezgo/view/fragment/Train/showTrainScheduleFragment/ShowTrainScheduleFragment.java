package com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment;

import android.app.Dialog;
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
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Singleton.CurrentTrainSchedule;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.Utils.ScreenUtils;
import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.response.StationPerJourney;
import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.ItemStationAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.ItemTrainScheduleAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment.ShowTrainDiagramFragment;
import com.example.laptop88.ezgo.view.fragment.ticket.adapter.StationPerJourneyAdapter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class
ShowTrainScheduleFragment extends Fragment implements ShowTrainScheduleFragmentView, ItemTrainScheduleAdapter.GetTrainID {
    private ProgressDialog mProgressDialog;
    private ShowTrainScheduleFragmentPresenterImpl mShowTrainScheduleFragmentPresenterImpl;
    private RadioButton radioButton;


    @Nullable
    @BindView(R.id.rcvListTrainSchedule)
    RecyclerView rcvListTrainSchedule;

    @BindView(R.id.btnSorting)
    LinearLayout btnSorting;

    @BindView(R.id.btnFilter)
    LinearLayout btnFilter;

    @BindView(R.id.btnTrainType)
    LinearLayout btnTrainType;


//    @BindView(R.id.rcvListStationPerJourney)
//    RecyclerView rcvListStationPerJourney;

    private ItemTrainScheduleAdapter mRcvAdapter;
    private List<TrainSchedule> trainSchedules;
    private List<TrainSchedule> trainSchedules123;
    private sendDataTofragment sendDataTofragment;
    private StationPerJourneyAdapter mStationPerJourneyAdapter;

    public void setInterface(sendDataTofragment sendDataTofragment) {
        this.sendDataTofragment = sendDataTofragment;
    }

    public ShowTrainScheduleFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_single_train_schedules, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = this.getArguments();
        trainSchedules = new ArrayList<>();
        trainSchedules123 = new ArrayList<>();
        trainSchedules = (List<TrainSchedule>) bundle.getSerializable("singleTrainSchedules");
        trainSchedules123 = (List<TrainSchedule>) bundle.getSerializable("returnTrainSchedules");

        CurrentTrainSchedule.getInstance().setListReturn(trainSchedules123);
//        trainSchedules = CurrentTrainSchedule.getInstance().getListSingle();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mRcvAdapter = new ItemTrainScheduleAdapter(getActivity(), fragmentManager, trainSchedules, this, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        rcvListTrainSchedule.setLayoutManager(layoutManager);
        rcvListTrainSchedule.setAdapter(mRcvAdapter);
        mRcvAdapter.notifyDataSetChanged();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
//        if (toolbar != null) {
//            ((BookingActivity) getActivity()).setSupportActionBar(toolbar);
//            if (((BookingActivity) getActivity()).getSupportActionBar() != null) {
//                ((BookingActivity) getActivity()).getSupportActionBar().setTitle("Train Schedule");
//                ((BookingActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
//            }
//        }

        ((BookingActivity) getActivity()).setTitleToolBar("Single Schedule");
        ((BookingActivity) getActivity()).setVisiblePaymentBar(Constants.VisibilityType.GONE);
        showToast("Success");
        return view;
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
    public void showTrainDiagram(TrainDetailResponse trainDetailResponse) {
        TrainDetailResponse train = new TrainDetailResponse();
        if (trainDetailResponse == null) {
            showToast("Couldn't find train");
        } else {
            train = trainDetailResponse;
        }
        Bundle bundle = new Bundle();
//        bundle.putSerializable("trainSchedule", singleTrainSchedule);

        bundle.putSerializable("trainDetailResponse", train);
        ShowTrainDiagramFragment mFragment = new ShowTrainDiagramFragment();
        mFragment.setArguments(bundle);
        pushFragment(BookingActivity.PushFrgType.REPLACE, mFragment, mFragment.getTag(), R.id.home_container);


    }

    @Override
    public void onClickTrainScheduleListener(TrainSchedule trainSchedule) {
        CurrentTrainSchedule.getInstance().setDepartureSchedule(trainSchedule);
        mShowTrainScheduleFragmentPresenterImpl = new ShowTrainScheduleFragmentPresenterImpl(this);
        mShowTrainScheduleFragmentPresenterImpl.getTrainDiagramByTrainScheduleID(trainSchedule.getTrainScheduleID());

    }

    public List<TrainSchedule> searchByFilter(List<TrainSchedule> trainScheduleList) {
        List<TrainSchedule> result = new ArrayList<>();

        return result;
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

    public interface sendDataTofragment {
        void sendData(List<TrainSchedule> trainSchedules);
    }

    public void setPopUpAdapter(List<StationPerJourney> stationPerJourneys) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_list_station_per_journey);
        ImageView imageView = dialog.findViewById(R.id.btnCancel);
        dialog.setTitle("Station");
        RecyclerView rcvListStationPerJourney = dialog.findViewById(R.id.rcvListStationPerJourney);
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mStationPerJourneyAdapter = new StationPerJourneyAdapter(getActivity(), R.layout.fragment_list_station_per_journey, stationPerJourneys);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        rcvListStationPerJourney.setLayoutManager(layoutManager);
        rcvListStationPerJourney.setAdapter(mStationPerJourneyAdapter);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout((int) (ScreenUtils.getWithScreen(getActivity()) * 1), (int) (ScreenUtils.getheightScreen(getActivity()) * 0.7));
            window.setGravity(Gravity.CENTER);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }
        dialog.show();
    }

    @OnClick(R.id.btnSorting)
    public void showSortingDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_sort);
        final RadioGroup radioGroup = (RadioGroup) dialog.findViewById(R.id.radioGroup);
        final Button btnOK = dialog.findViewById(R.id.btnOK);
        final Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton =  dialog.findViewById(selectedId);
//                Toast.makeText(getActivity(), radioButton.getText(), Toast.LENGTH_SHORT).show();
                switch (selectedId){
                    case R.id.rdDepartureDate:{
                        mRcvAdapter.sortByDepartureTime();
                        break;
                    }
                    case R.id.rdDuration:{
                        mRcvAdapter.sortByDuration();
                        break;
                    }
                    case R.id.rdTicketFare:{
                        mRcvAdapter.sortByTicketFare();
                        break;
                    }
                    case R.id.rdArrivalDate:{
                        mRcvAdapter.sortByArrivalTime();
                        break;
                    }
                }
                dialog.dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}