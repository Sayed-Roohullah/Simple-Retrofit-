package com.roohi.simple_retrofit.retrofit

import retrofit2.Call
import com.roohi.simple_retrofit.data.CountryModel
import retrofit2.http.GET

interface RetroServiceInterface {
    @GET("v2")
    fun getCountryList(): Call<List<CountryModel>>
 }