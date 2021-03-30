package com.example.synchronoss.test.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather_Base_Pojo(
    @SerializedName("coord")
    val coord: CoordResponse,
    @SerializedName("weather")
    val weather: List<WeatherResponse>,
    @SerializedName("base")
    val base: String,
    @SerializedName("main")
    val main: MainResponse,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("wind")
    val wind: WindResponse,
    @SerializedName("clouds")
    val clouds: CloudsResponse,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("sys")
    val sys: SysResponse,
    @SerializedName("timezone")
    val timezone: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("cod")
    val cod: Int


)