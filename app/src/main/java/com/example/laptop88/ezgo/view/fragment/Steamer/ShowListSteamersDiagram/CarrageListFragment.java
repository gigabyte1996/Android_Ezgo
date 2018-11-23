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

import java.util.List;

import butterknife.BindView;

public class CarrageListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_steamer, container, false);
        return view;
    }

}
