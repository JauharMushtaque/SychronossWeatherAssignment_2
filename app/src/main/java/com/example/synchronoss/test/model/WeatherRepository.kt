package com.example.synchronoss.test.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.synchronoss.test.model.response.Weather_Base_Pojo
import com.example.synchronoss.test.network.api.RetrofitProvider
import com.example.synchronoss.test.network.api.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository(){
    val retrofitService: RetrofitService by lazy {
        RetrofitProvider.getRetrofitService()
    }

    val weatherDailyDataCall: Call<Weather_Base_Pojo> = retrofitService.getWeather()
    var weatherDailyMutableLiveData = MutableLiveData<Weather_Base_Pojo>()
    init {
        getDailyWeather()
    }

    fun getDailyWeather() {

        weatherDailyDataCall.enqueue(object : Callback<Weather_Base_Pojo?> {
            override fun onResponse(call: Call<Weather_Base_Pojo?>, response: Response<Weather_Base_Pojo?>
            ) {
                return weatherDailyMutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Weather_Base_Pojo?>, t: Throwable) {
                return weatherDailyMutableLiveData.postValue(null)
            }
        })
    }

    fun getWeatherDailyResponseLiveData(): LiveData<Weather_Base_Pojo> {
        return weatherDailyMutableLiveData
    }
}