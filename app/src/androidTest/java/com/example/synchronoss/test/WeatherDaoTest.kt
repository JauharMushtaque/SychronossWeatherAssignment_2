package com.example.synchronoss.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.synchronoss.test.database.entity.WeatherEntity
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class WeatherDaoTest: WeatherDatabaseTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun insertWeatherTest() {
        val weather = WeatherEntity(0,"Bengaluru", "Bengaluru", 1617151583, 710,
            50.0f, 50, 50, 50.0f, 50.0f, 50.0f, 50.0f, 50, 50 )
        val result = appDatabase.weatherDao().insertWeather(weather)
        assert(result != null)
        val city_name = appDatabase.weatherDao().getWeather().city_name
        assertEquals("Bengaluru", city_name)
    }
}