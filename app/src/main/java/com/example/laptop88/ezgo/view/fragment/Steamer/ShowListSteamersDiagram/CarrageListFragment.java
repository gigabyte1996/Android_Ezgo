package com.example.laptop88.ezgo.view.fragment.Steamer.ShowListSteamersDiagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.view.fragment.Train.adapter.RecyclerViewSteamerItemAdapter;

import java.util.List;

import butterknife.BindView;

public class CarrageListFragment extends Fragment {
    @BindView(R.id.recyclerListCarrage)
    List<Steamer> steamerList;

    private RecyclerViewSteamerItemAdapter mRcvAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_steamer, container, false);
        Bundle bundle = this.getArguments();
        String carrageID = bundle.getString("carrageID");
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        mRcvAdapter = new RecyclerViewSteamerItemAdapter(getActivity(), fragmentManager, )

        //        trainSchedules = new ArrayList<>();
//        trainSchedules =(List<TrainSchedule>) bundle.getSerializable("trainSchedule" );
//        Log.d("aaaaaaaaaaa", trainSchedules.toString());
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        mRcvAdapter = new RecyclerViewItemTrainScheduleAdapter(getActivity(), fragmentManager, trainSchedules);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        layoutManager.setOrientation(LinearLayout.VERTICAL);
//
//        recyclerListTrainSchedule.setLayoutManager(layoutManager);
//        recyclerListTrainSchedule.setAdapter(mRcvAdapter);
//
//        showToast("Success");
        return view;
    }

    public void updateView(String carrageId) {

    }
}
