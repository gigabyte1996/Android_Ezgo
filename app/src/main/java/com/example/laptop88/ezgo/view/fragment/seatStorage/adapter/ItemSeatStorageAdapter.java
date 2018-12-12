package com.example.laptop88.ezgo.view.fragment.seatStorage.adapter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.Utils.Constants;
import com.example.laptop88.ezgo.response.Passenger;
import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.Ticket;
import com.example.laptop88.ezgo.response.TicketRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ItemSeatStorageAdapter extends  RecyclerView.Adapter<ItemSeatStorageAdapter.RecyclerViewHolder> {
    private Context mContext;
    private FragmentManager mFragmentManager;
    private List<SeatStorage> data;
    private String passengerObjectType[];
    private List<Ticket> ticketList;
    private List<Passenger> passengers;
    private List<TicketRequest> ticketRequestList;


    public ItemSeatStorageAdapter(Context mContext, FragmentManager mFragmentManager, List<SeatStorage> data, String[] passengerObjectType, List<Passenger> passengers, List<TicketRequest> ticketRequestList ) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.data = data;
        this.passengerObjectType = passengerObjectType;
        this.passengers = passengers;
        this.ticketRequestList = ticketRequestList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_seat_storage, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemSeatStorageAdapter.RecyclerViewHolder holder, final int position) {
        final String trainName = data.get(position).getTrainName();
        final String trainScheduleName = data.get(position).getScheduleName();
        final String departureTime = data.get(position).getDepartureTime();
        final Integer carrageType = data.get(position).getCarrageType();
        final Integer carrageNumber = data.get(position).getCarrageNumber();
        final Integer seatNumber = data.get(position).getSeatNumber();
        final Integer ticketFare = data.get(position).getFare();
        final Integer trainScheduleID = data.get(position).getTrainScheduleID();
        final String fromStation = data.get(position).getFromStation();
        final String toStation = data.get(position).getToStation();


        holder.txtTrainName.setText(String.valueOf(trainName));
        holder.txtTrainScheduleName.setText(trainScheduleName);
        holder.txtTicketFare.setText(String.valueOf(ticketFare) + " VND");
        holder.txtDepartureTime.setText(departureTime);
        switch (carrageType) {
            case Constants.CarrageType.SOFT_SEAT: {
                holder.txtCarrageType.setText("Soft seat");
                break;
            }
            case Constants.CarrageType.HARD_BED: {
                holder.txtCarrageType.setText("Hard bed");
                break;
            }
            case Constants.CarrageType.SOFT_BED: {
                holder.txtCarrageType.setText("Soft bed");
                break;
            }
            case Constants.CarrageType.HARD_SEAT: {
                holder.txtCarrageType.setText("Hard seat");
                break;
            }
        }
        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_spinner_item, passengerObjectType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spObject.setAdapter(adapter);
        holder.spObject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case (0):
                        holder.tilDateOfBirth.setVisibility(View.GONE);
                        holder.tilIdentification.setVisibility(View.VISIBLE);
                        break;
                    case (1):
                        holder.tilDateOfBirth.setVisibility(View.VISIBLE);
                        holder.tilIdentification.setVisibility(View.GONE);
                }
                passengers.get(position).ticketType = (holder.spObject.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                holder.tilDateOfBirth.setVisibility(View.GONE);
                holder.tilIdentification.setVisibility(View.VISIBLE);
            }
        });

        holder.edtDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        calendar.set(year, month, day);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        holder.edtDateOfBirth.setText(simpleDateFormat.format(calendar.getTime()));
                        System.out.println(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, onDateSetListener, year, month, day);
                datePickerDialog.show();
            }
        });
        holder.txtCarrageNumber.setText("Carrage number: " + String.valueOf(carrageNumber));
        holder.txtSeatNumber.setText("Seat : " + String.valueOf(seatNumber));
        holder.imgDelete.setVisibility(View.INVISIBLE);
        holder.edtFullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                passengers.get(position).passengerName = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        holder.edtIdentification.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                passengers.get(position).identificationNumber = (charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        holder.edtDateOfBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                passengers.get(position).dateOfBirth = (charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        ticketRequestList.get(position).seatStorage = (data.get(position));
        ticketRequestList.get(position).passenger = (passengers.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtTrainName;
        TextView txtTrainScheduleName;
        TextView txtTicketFare;
        TextView txtDepartureTime;
        TextView txtCarrageType;
        TextView txtCarrageNumber;
        TextView txtSeatNumber;
        ImageView imgDelete;
        EditText edtFullName;
        Spinner spObject;
        EditText edtIdentification;
        EditText edtDateOfBirth;
        TextInputLayout tilIdentification;
        TextInputLayout tilDateOfBirth;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtCarrageNumber = itemView.findViewById(R.id.txtCarrageNumber);
            txtTicketFare = itemView.findViewById(R.id.TicketFare);
            txtTrainName = itemView.findViewById(R.id.TrainName);
            txtTrainScheduleName = itemView.findViewById(R.id.TrainScheduleName);
            txtDepartureTime = itemView.findViewById(R.id.llDepartureTime);
            txtCarrageType = itemView.findViewById(R.id.txtCarrageType);
            txtSeatNumber = itemView.findViewById(R.id.txtSeatNumber);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            edtFullName = itemView.findViewById(R.id.edtFullName);
            edtIdentification = itemView.findViewById(R.id.edtIdenfiticationNumber);
            spObject = itemView.findViewById(R.id.spObject);
            edtDateOfBirth = itemView.findViewById(R.id.edtDateOfBirth);
            tilIdentification = itemView.findViewById(R.id.ipIdenfiticationNumber);
            tilDateOfBirth = itemView.findViewById(R.id.ipDateOfBirth);
        }
    }

    public List<TicketRequest> retrieveData()
    {
        return ticketRequestList;
    }

}

