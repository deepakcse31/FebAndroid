package com.example.febandroid;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login/v2/getOtp")
    Call<ResponseModel> createUser(@Body JsonObject user);
}
