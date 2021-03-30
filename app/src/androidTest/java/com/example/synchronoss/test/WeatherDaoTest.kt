package com.example.synchronoss.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.synchronoss.test.database.entity.WeatherEntity
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class WeatherDaoTest: WeatherDatabaseTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun insertWeatherTest() {
        val weather = WeatherEntity(0,"Dublin City", "Dublin City", 600, 710,
            50.0f, 50, 50, 50.0f, 50.0f, 50.0f, 50.0f, 50, 50 )
        appDatabase.weatherDao().insertWeather(weather)
        val city_name = appDatabase.weatherDao().getWeather().city_name
        Assert.assertEquals("Dublin City", city_name)
    }
}