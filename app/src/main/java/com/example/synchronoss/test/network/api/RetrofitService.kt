package com.example.synchronoss.test.network.api

import com.example.synchronoss.test.model.response.Weather_Base_Pojo
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("data/2.5/weather?id=7778677&appid=5ad7218f2e11df834b0eaf3a33a39d2a")
    fun getWeather(
    ): Call<Weather_Base_Pojo>
}