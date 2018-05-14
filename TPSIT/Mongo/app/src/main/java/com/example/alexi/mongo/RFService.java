package com.example.alexi.mongo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


interface RFService {

    String BASE_URL = "http://localhost:8080/";

    @GET("tpsit/tpsit/")
    Call<POJO> getPOJO(); //get the Pojo object

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
