package com.example.synchronoss.test.database.load_db

import android.util.Log
import com.example.synchronoss.test.database.WeatherDatabase
import com.example.synchronoss.test.database.entity.WeatherEntity
import com.example.synchronoss.test.model.response.MainResponse
import com.example.synchronoss.test.model.response.SysResponse
import com.example.synchronoss.test.model.response.Weather_Base_Pojo
import com.example.synchronoss.test.model.response.WindResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val TAG: String = "WeatherAPI"

fun saveWeatherDataInDatabase(
    weatherDB: WeatherDatabase,
    weatherInfo: Weather_Base_Pojo
): Boolean {
    try {
        val mainResponse: MainResponse = weatherInfo.main
        val sysResponse: SysResponse = weatherInfo.sys
        val windResponse: WindResponse = weatherInfo.wind

        GlobalScope.launch {
            weatherInfo.let {
                val weatherEntity = WeatherEntity(
                    weatherInfo.id,
                    weatherInfo.name,
                    sysResponse.country,
                    sysResponse.sunrise,
                    sysResponse.sunset,
                     windResponse.speed,
                     windResponse.deg,
                     weatherInfo.visibility,
                    mainResponse.temp,
                    mainResponse.feels_like,
                    mainResponse.temp_min,
                    mainResponse.temp_max,
                    mainResponse.pressure,
                    mainResponse.humidity
                )
                weatherDB.weatherDao().insertWeather(weatherEntity)
            }

        }
        return true
    } catch (exception: Exception) {
        return false
    }
}