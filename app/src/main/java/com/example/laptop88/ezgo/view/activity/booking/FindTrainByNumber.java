package com.example.laptop88.ezgo.view.activity.booking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;

public class FindTrainByNumber extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.getActivity().setTitle("Find train - By Station");
        return inflater.inflate(R.layout.fragment_find_train_by_number, container, false);
    }

    public void setTicketNumber(String ticketNumber) {
        TextView textViewFindTrainByNumber = this.getActivity().findViewById(R.id.txtFindTryByNumber);
        textViewFindTrainByNumber.setText(ticketNumber);
    }
}
