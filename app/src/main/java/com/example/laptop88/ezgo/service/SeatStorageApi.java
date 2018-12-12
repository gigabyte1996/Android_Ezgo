package com.example.laptop88.ezgo.service;


import com.example.laptop88.ezgo.response.SeatStorage;
import com.example.laptop88.ezgo.response.SeatStorageDeleteRequest;
import com.example.laptop88.ezgo.response.SeatStorageResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.HTTP;
import retrofit2.http.POST;

public interface SeatStorageApi {

    @POST("/api/seatStorage/add")
    Call<SeatStorageResponse> addSeatStorage(@Body SeatStorage requestTrain);

    @POST("api/seatStorage")
    Call<SeatStorageResponse> getSeatStorageByUserID(@Body Integer userID);

    @HTTP(method = "DELETE", path = "/api/seatStorage",  hasBody = true)
    Call<SeatStorageResponse> deleteSeatStorage(@Body SeatStorageDeleteRequest seatStorageDeleteRequest);

}
