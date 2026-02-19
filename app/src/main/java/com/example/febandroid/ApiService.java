package com.example.febandroid;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("login/v2/getOtp")
    Call<ResponseModel> getOtp(@Body JsonObject jsonObject);

    @GET("https://imdb.iamidiotareyoutoo.com/search?")
    Call<MovieResponse> getMovies(@Query("q") String name);

}
