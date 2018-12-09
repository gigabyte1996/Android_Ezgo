//package com.example.laptop88.ezgo.Utils;
////
////import android.content.Context;
//import android.content.SharedPreferences;
////
////import com.example.laptop88.ezgo.response.Seat;
////import com.example.laptop88.ezgo.response.Steamer;
////import com.example.laptop88.ezgo.response.TrainDetailResponse;
////import com.google.gson.Gson;
////
////import java.util.List;
////
//public class SeatStorage {
//    private static final String SAVED_SEAT = "storedDATA";
//    private static final String STREAMER = "storedSTREAMER";
//    private static final String SEAT_STATUS = "storedSEATSTATUS";
//
//    SharedPreferences pref;
//    SharedPreferences.Editor editor;
////    Context _context;
////    int PRIVATE_MODE = 0;
////
////    public SeatStorage(Context context) {
////        this._context = context;
////    }
////
////    public void storageDatas (TrainDetailResponse trainDetailResponse) {
////        pref = _context.getSharedPreferences(SAVED_SEAT, PRIVATE_MODE);
////        editor = pref.edit();
////        editor.clear();
////        Gson gson = new Gson();
////        editor.putString(SAVED_SEAT, gson.toJson(trainDetailResponse));
////        editor.commit();
////    }
////
////    public TrainDetailResponse loadDatas () {
////        pref = _context.getSharedPreferences(SAVED_SEAT, PRIVATE_MODE);
////        String json = pref.getString(SAVED_SEAT, null);
////        Gson gson = new Gson();
////        TrainDetailResponse trainDetailResponse = gson.fromJson(json, TrainDetailResponse.class);
////        return trainDetailResponse;
////    }
////
////    public void storageSEAT (List<Seat> seatList) {
////        pref = _context.getSharedPreferences(SEAT_STATUS, PRIVATE_MODE);
////        editor = pref.edit();
////        Gson gson = new Gson();
////        editor.putString(STREAMER, gson.toJson(seatList));
////        editor.commit();
////    }
////
////    public void clearSEAT() {
////        pref = _context.getSharedPreferences(SEAT_STATUS, PRIVATE_MODE);
////        editor.clear();
////        editor.commit();
////    }
////
////    public List<Seat> loadSEAT() {
////        pref = _context.getSharedPreferences(SEAT_STATUS, PRIVATE_MODE);
////        String json = pref.getString(SEAT_STATUS, null);
////        Gson gson = new Gson();
////        List<Seat> seatList =(List<Seat>) gson.fromJson(json, Seat.class);
////        return seatList;
////    }
//}
