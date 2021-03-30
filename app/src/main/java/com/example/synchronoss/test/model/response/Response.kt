package com.example.synchronoss.test.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*


data class CloudsResponse(
    @SerializedName("all")
    val all: Int? = null
)

data class CoordResponse(
    @SerializedName("lat")
    val lat: Double,

    @SerializedName("lon")
    val lon: Double
)

data class SysResponse(
    @SerializedName("type")
    val type: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int
)

data class WindResponse(
    @SerializedName("speed")
    val speed: Float,
    @SerializedName("deg")
    val deg: Int
)


data class WeatherResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("main")
    var main: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("icon")
    var icon: String? = null
)


data class MainResponse(
    @SerializedName("temp")
    val temp: Float,
    @SerializedName("feels_like")
    val feels_like: Float,
    @SerializedName("temp_min")
    val temp_min: Float,
    @SerializedName("temp_max")
    val temp_max: Float,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("humidity")
    val humidity: Int
)

data class WeatherDailyData(
    @SerializedName("lat")
    var lat: Double? = null,

    @SerializedName("lon")
    val lon: Double? = null,

    @SerializedName("timezone")
    val timezone: String? = null,

    @SerializedName("timezoneOffset")
    val timezoneOffset: Int? = null,

    @SerializedName("current")
    val current: Current? = null,

    @SerializedName("minutely")
    val minutely: List<Minutely>? = null,

    @SerializedName("hourly")
    val hourly: List<Hourly>? = null,

    @SerializedName("daily")
    val daily: List<Daily>? = null,

    @SerializedName("alerts")
    val alerts: List<Alert>? = null,

    @SerializedName("additionalProperties")
    val additionalProperties: Map<String, Any> = HashMap()
)

data class Current(
    var dt: Int? = null,
    var sunrise: Int? = null,
    var sunset: Int? = null,
    var temp: Double? = null,
    var feelsLike: Double? = null,
    var pressure: Int? = null,
    var humidity: Int? = null,
    var dewPoint: Double? = null,
    var uvi: Double? = null,
    var clouds: Int? = null,
    var visibility: Int? = null,
    var windSpeed: Double? = null,
    var windDeg: Int? = null,
    var weather: List<Weather>? = null,
    var rain: Rain? = null
) {
}

data class Rain(
    @SerializedName("3h")
    @Expose
    private var _3h: Double? = null
) {

}

data class Minutely(
    var dt: Int? = null,
    var precipitation: Double = 0.0,
    val additionalProperties: MutableMap<String, Any> = HashMap()
) {
}

data class Hourly(
    var dt: Int? = null,
    var temp: Double? = null,
    var feelsLike: Double? = null,
    var pressure: Int? = null,
    var humidity: Int? = null,
    var dewPoint: Double? = null,
    var uvi: Double? = null,
    var clouds: Int? = null,
    var visibility: Int? = null,
    var windSpeed: Double? = null,
    var windDeg: Int? = null,
    var weather: List<Weather_>? = null,
    var pop: Double? = null,
    var rain: Rain_? = null,
    val additionalProperties: MutableMap<String, Any> = HashMap()
) {
}

data class Daily(
    var dt: Int? = null,
    var sunrise: Int? = null,
    var sunset: Int? = null,
    var temp: Temp? = null,
    var feelsLike: FeelsLike? = null,
    var pressure: Int? = null,
    var humidity: Int? = null,
    var dewPoint: Double? = null,
    var windSpeed: Double? = null,
    var windDeg: Int? = null,
    var weather: List<Weather__>? = null,
    var clouds: Int? = null,
    var pop: Double? = null,
    var rain: Double? = null,
    var uvi: Double? = null,
    val additionalProperties: MutableMap<String, Any> = HashMap()
) {

}

data class Alert(
    var senderName: String? = null,
    var event: String? = null,
    var start: Int? = null,
    var end: Int? = null,
    var description: String? = null,
    val additionalProperties: MutableMap<String, Any> = HashMap()
) {

}

data class Weather(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("main")
    @Expose
    var main: String? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("icon")
    @Expose
    var icon: String? = null
) {
}

data class Weather_(
    var id: Int? = null,
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null,
    val additionalProperties: MutableMap<String, Any> = HashMap()
) {
}

data class Temp(
    var day: Double? = null,
    var min: Double? = null,
    var max: Double? = null,
    var night: Double? = null,
    var eve: Double? = null,
    var morn: Double? = null,
    val additionalProperties: MutableMap<String, Any> = HashMap()
) {
}

data class Rain_(
    private var _1h: Double? = null,
    val additionalProperties: MutableMap<String, Any> = HashMap()
) {
}

data class FeelsLike(
    var day: Double? = null,
    var night: Double? = null,
    var eve: Double? = null,
    var morn: Double? = null,
    val additionalProperties: MutableMap<String, Any> = HashMap()
) {
}

data class Weather__(
    var id: Int? = null,
    var main: String? = null,
    var description: String? = null,
    var icon: String? = null,
    val additionalProperties: MutableMap<String, Any> = HashMap()
) {
}

data class WeatherData(
    var coord: Coord? = null,
    var weather: List<Weather>? = null,
    var base: String? = null,
    var main: Main? = null,
    var visibility: Int = 0,
    var wind: Wind? = null,
    var clouds: Clouds? = null,
    var dt: Int = 0,
    var sys: Sys? = null,
    var timezone: Int = 0,
    var id: Int = 0,
    var name: String? = null,
    var cod: Int = 0
){

    //JAUHAR
    /*public class Main{
        public double temp;
        public double feels_like;
        public double temp_min;
        public double temp_max;
        public int pressure;
        public int humidity;
    }*/
    class Sys{
        var type = 0
        var id = 0
        var country: String? = null
        var sunrise = 0
        var sunset = 0
    }
}

data class Coord(
    @SerializedName("lat")
    @Expose
    var lat: Double ,

    @SerializedName("lon")
    @Expose
    var lon: Double
) {
}

data class Main(
    @SerializedName("temp")
    @Expose
    var temp: Double? = null,

    @SerializedName("feels_like")
    @Expose
    var feelsLike: Double? = null,

    @SerializedName("temp_min")
    @Expose
    var tempMin: Double? = null,

    @SerializedName("temp_max")
    @Expose
    var tempMax: Double? = null,

    @SerializedName("pressure")
    @Expose
    var pressure: Int? = null,

    @SerializedName("sea_level")
    @Expose
    var seaLevel: Int? = null,

    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Int? = null,

    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null,

    @SerializedName("temp_kf")
    @Expose
    var tempKf: Double? = null
) {
}

data class Wind(
    @SerializedName("speed")
    @Expose
    var speed: Double? = null,

    @SerializedName("deg")
    @Expose
    var deg: Int? = null
) {
}

data class Clouds(
    @SerializedName("all")
    @Expose
    var all: Int? = null) {
}




