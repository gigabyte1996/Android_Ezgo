package com.example.laptop88.ezgo.view.fragment.ticket.ShowticketDetailFragment;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Adminstraitor;
import com.example.laptop88.ezgo.response.StationPerJourney;
import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.response.TicketDetailsResponse;
import com.example.laptop88.ezgo.view.activity.booking.BookingActivity;
import com.example.laptop88.ezgo.view.fragment.ticket.adapter.StationPerJourneyAdapter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowticketDetailFragment extends Fragment {
    private Ticket ticket;
    private List<StationPerJourney> stationPerJourneys;
    private StationPerJourneyAdapter mRcvAdapter;
    private Adminstraitor adminstraitor;

    @BindView(R.id.imgQRCode)
    ImageView imgQRCode;

    @BindView(R.id.rcvTrainSchedule)
    RecyclerView rcvTrainSchedule;

    @BindView(R.id.fromStation)
    TextView fromStation;

    @BindView(R.id.toStation)
    TextView toStation;

    @BindView(R.id.txtDepartureTime)
    TextView departureTime;

    @BindView(R.id.txtCarrageType)
    TextView carrageType;

    @BindView(R.id.txtCarrageNumber)
    TextView carrageNumber;

    @BindView(R.id.txtSeatNumber)
    TextView seatNumber;

    @BindView(R.id.txtpassengerName)
    TextView passengerName;

    @BindView(R.id.txtTicketType)
    TextView ticketType;

    @BindView(R.id.TrainName)
    TextView trainName;

    @BindView(R.id.TrainScheduleName)
    TextView trainScheduleName;

    @BindView(R.id.txtFare)
    TextView fare;

    @BindView(R.id.txtAdminName)
    TextView adminName;

    @BindView(R.id.txtAdminPhoneNumber)
    TextView adminPhoneNum;

    @BindView(R.id.llStationPerJourney)
    LinearLayout llStationPerJourney;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket_detail, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = this.getArguments();
        ticket = new Ticket();
        ticket = (Ticket) bundle.getSerializable("ticketDetails");
        stationPerJourneys = (List<StationPerJourney>) bundle.getSerializable("trainScheduleDetails");
        adminstraitor = (Adminstraitor) bundle.getSerializable("adminstraitorInfo");

        trainName.setText(ticket.getTrainName());
        trainScheduleName.setText(ticket.getTrainScheduleName());
        fare.setText(String.valueOf(ticket.getFare()));
        fromStation.setText(ticket.getFromStation());
        toStation.setText(ticket.getToStation());
        departureTime.setText(ticket.getDepartureTime());
        carrageNumber.setText("Carriage : " + String.valueOf(ticket.getCarrageNumber()));
        seatNumber.setText("Seat : " + String.valueOf(ticket.getSeatNumber()));
        switch (ticket.getCarrageType()) {
            case Constants.CarrageType.SOFT_SEAT: {
                carrageType.setText("Soft seat");
                break;
            }
            case Constants.CarrageType.HARD_BED: {
                carrageType.setText("Hard bed");
                break;
            }
            case Constants.CarrageType.SOFT_BED: {
                carrageType.setText("Soft bed");
                break;
            }
            case Constants.CarrageType.HARD_SEAT: {
                carrageType.setText("Hard seat");
                break;
            }
        }
        passengerName.setText(ticket.getPassengerName());
        ticketType.setText(ticket.getTicketType());
        if (ticket.getIdentificationNumber() == null){

        }

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        mRcvAdapter = new StationPerJourneyAdapter(getActivity(), stationPerJourneys, fragmentManager);
//        mRcvAdapter = new StationPerJourneyAdapter(getActivity(), fragmentManager, stationPerJourneys);
//        mRcvAdapter.setCallback(new ItemTicketAdapter.setTicketCallback() {
//            @Override
//            public void getTicketByUserID(int ticketID) {
//                getTicketByUserID(ticketID);
//            }
//        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        rcvTrainSchedule.setLayoutManager(layoutManager);
        rcvTrainSchedule.setAdapter(mRcvAdapter);

        adminName.setText(adminstraitor.getAdminstraitorName());
        adminPhoneNum.setText(adminstraitor.getAdminPhoneNum());
//        setUpViews();
        adminPhoneNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });

        generateQRcode(ticket.getTicketCode(), imgQRCode);
        return view;
    }

    public void generateQRcode(String ticketCode, ImageView imgQRCode) {
        ticketCode = ticketCode.trim();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(ticketCode, BarcodeFormat.QR_CODE, 100, 100);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imgQRCode.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private void makePhoneCall() {
        String number = adminPhoneNum.getText().toString();
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, Constants.REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(getActivity(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == Constants.REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(getActivity(), "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick(R.id.llStationPerJourney)
    public void showStation(){
        if (rcvTrainSchedule.getVisibility() == View.GONE){
            rcvTrainSchedule.setVisibility(View.VISIBLE);
        }else {
            rcvTrainSchedule.setVisibility(View.GONE);
        }
    }
}
