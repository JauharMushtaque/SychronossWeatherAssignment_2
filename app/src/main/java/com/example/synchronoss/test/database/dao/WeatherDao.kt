package com.example.synchronoss.test.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.synchronoss.test.database.entity.WeatherEntity

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weatherEntity: WeatherEntity)

    @Query("SELECT * FROM weather_table ORDER BY id DESC")
    fun getWeather(): WeatherEntity
}