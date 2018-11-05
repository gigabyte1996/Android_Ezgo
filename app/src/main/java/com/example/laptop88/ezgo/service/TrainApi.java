package com.example.laptop88.ezgo.service;

import com.example.laptop88.ezgo.response.TrainRequest;
import com.example.laptop88.ezgo.response.TrainScheduleResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TrainApi {

    @POST("/api/train/search")
    Call<TrainScheduleResponse> searchTrain(@Body TrainRequest requestTrain);

}
