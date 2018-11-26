package com.example.laptop88.ezgo.view.activity.booking1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Station;

import java.util.ArrayList;
import java.util.List;

public class FindTrainByNumber extends Fragment {
    private List<Station> stations;
    private Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.getActivity().setTitle("Find train - By StationResponse");
        stations = new ArrayList<>();
        bundle = this.getArguments();
        stations = (List<Station>) bundle.getSerializable("station");
        Log.d("BBBBBBBBBBBBB", stations.get(2).getStationName());
        return inflater.inflate(R.layout.fragment_find_train_by_number, container, false);
    }

    public void setTicketNumber(String ticketNumber) {
        TextView textViewFindTrainByNumber = this.getActivity().findViewById(R.id.txtFindTryByNumber);
        textViewFindTrainByNumber.setText(ticketNumber);
    }
}
