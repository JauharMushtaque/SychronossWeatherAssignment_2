package com.example.synchronoss.test.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val city_name: String,
    val country_name: String,
    val sunrise: Int,
    val sunset: Int? = null,
    val speed: Float,
    val deg: Int,
    val visibility: Int,
    val temp: Float,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float,
    val pressure: Int,
    val humidity: Int
)