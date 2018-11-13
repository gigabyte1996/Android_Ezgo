package com.example.laptop88.ezgo.view.fragment.seat.SeatDiagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laptop88.ezgo.R;

import butterknife.ButterKnife;

public class SeatDiagramFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steamer_diagram, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = this.getArguments();

        return  view;
    }

    public void updateView(String carrageId) {

    }
}
