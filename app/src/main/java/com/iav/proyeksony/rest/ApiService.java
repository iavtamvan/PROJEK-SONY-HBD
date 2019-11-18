package com.iav.proyeksony.rest;

import com.iav.proyeksony.model.Model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("exec")
    Call<ArrayList<Model>> getSplashScreen(@Query("action") String action,
                                   @Query("sheetName") String sheetName);


    @GET("exec")
    Call<ArrayList<Model>> getSlider(@Query("action") String action,
                                   @Query("sheetName") String sheetName);

    @GET("exec")
    Call<ArrayList<Model>> getMenuUtama(@Query("action") String action,
                                   @Query("sheetName") String sheetName);

    @GET("exec")
    Call<ArrayList<Model>> getMenuDua(@Query("action") String action,
                                   @Query("sheetName") String sheetName);


}
