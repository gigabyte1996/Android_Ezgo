package com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.ItemTrainScheduleAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment.ShowTrainDiagramFragment;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class
ShowTrainScheduleFragment extends Fragment implements ShowTrainScheduleFragmentView, ItemTrainScheduleAdapter.GetTrainID {
    private ProgressDialog mProgressDialog;
    private ShowTrainScheduleFragmentPresenter mShowTrainScheduleFragmentPresenter;
    private ShowTrainScheduleFragmentPresenterImpl mShowTrainScheduleFragmentPresenterImpl;
    private FragmentManager mFragmentManager;

    @Nullable
    @BindView(R.id.rcvListTrainSchedule)
    RecyclerView rcvListTrainSchedule;


    private ItemTrainScheduleAdapter mRcvAdapter;
    private List<TrainSchedule> trainSchedules;

    public ShowTrainScheduleFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_train_schedules, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = this.getArguments();
        trainSchedules = new ArrayList<>();
        trainSchedules = (List<TrainSchedule>) bundle.getSerializable("trainSchedule");
        Log.d("aaaaaaaaaaa", trainSchedules.toString());
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mRcvAdapter = new ItemTrainScheduleAdapter(getActivity(), fragmentManager, trainSchedules, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);

        rcvListTrainSchedule.setLayoutManager(layoutManager);
        rcvListTrainSchedule.setAdapter(mRcvAdapter);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        if (toolbar != null) {
            ((BookingActivity) getActivity()).setSupportActionBar(toolbar);
            if (((BookingActivity) getActivity()).getSupportActionBar() != null) {
                ((BookingActivity) getActivity()).getSupportActionBar().setTitle("Train Schedule");
                ((BookingActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
            }
        }
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
        Log.d("listCarrage", trainDetailResponse.getSteamerList().size()+"");
        if (trainDetailResponse == null) {
            showToast("Couldn't find train");
        } else {
            train = trainDetailResponse;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("trainDetailResponse",  train);
        ShowTrainDiagramFragment mFragment = new ShowTrainDiagramFragment();
        mFragment.setArguments(bundle);
        pushFragment(BookingActivity.PushFrgType.REPLACE, mFragment, mFragment.getTag(), R.id.home_container);


    }

    @Override
    public void onClickTrainScheduleListener(String trainID) {
        mShowTrainScheduleFragmentPresenterImpl = new ShowTrainScheduleFragmentPresenterImpl(this);
        mShowTrainScheduleFragmentPresenterImpl.getTrainDiagramByTrainID(trainID);

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
