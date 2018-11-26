package com.example.laptop88.ezgo.service;

import com.example.laptop88.ezgo.response.StationResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StationApi {

    @GET("/api/station")
    Call<StationResponse> getListStation();
}
