package com.example.laptop88.ezgo.view.fragment.Train.showTrainScheduleFragment;

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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.TrainDetailResponse;
import com.example.laptop88.ezgo.response.TrainSchedule;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.RecyclerViewItemTrainScheduleAdapter;
import com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment.ShowTrainDiagramFragment;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowTrainScheduleFragment extends Fragment implements ShowTrainScheduleFragmentView, RecyclerViewItemTrainScheduleAdapter.GetTrainID {
    private ProgressDialog mProgressDialog;
    private ShowTrainScheduleFragmentPresenter mShowTrainScheduleFragmentPresenter;
    private ShowTrainScheduleFragmentPresenterImpl mShowTrainScheduleFragmentPresenterImpl;
    private FragmentManager mFragmentManager;

    @Nullable
    @BindView(R.id.recyclerListTrainSchedule)
    RecyclerView recyclerListTrainSchedule;

    @BindView(R.id.btnTest)
    Button btnTest;

    private RecyclerViewItemTrainScheduleAdapter mRcvAdapter;
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
        mRcvAdapter = new RecyclerViewItemTrainScheduleAdapter(getActivity(), fragmentManager, trainSchedules, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);

        recyclerListTrainSchedule.setLayoutManager(layoutManager);
        recyclerListTrainSchedule.setAdapter(mRcvAdapter);

        showToast("Success");
        return view;
    }

    @OnClick({R.id.btnTest})
    public  void  onClick(View view){
        switch (view.getId()){
            case R.id.btnTest:
                mShowTrainScheduleFragmentPresenterImpl = new ShowTrainScheduleFragmentPresenterImpl(this);
                mShowTrainScheduleFragmentPresenterImpl.getTrainDiagramByTrainID("T1");
                break;
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
