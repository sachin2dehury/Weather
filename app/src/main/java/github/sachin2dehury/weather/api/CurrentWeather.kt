package github.sachin2dehury.weather.api

import com.squareup.moshi.Json

data class CoOrdinates(val lon: Float, val lat: Float)

data class WeatherDetails(val main: String, val description: String, val icon: String)

data class TempDetails(
    val temp: Float, val feels_like: Float, val temp_min: Float, val temp_max: Float,
    val pressure: Int, val humidity: Int
)

data class Wind(val speed: Float, val deg: Int)

data class Country(val country: String, val sunrise: Long, val sunset: Long)

data class CurrentWeather(
    @field:Json(name = "dt") val date: Long, //date
    @field:Json(name = "name") val location: String, //location
    @field:Json(name = "coord") val position: CoOrdinates, //position
    @field:Json(name = "main") val tempDetails: TempDetails, //temp
    @field:Json(name = "weather") val weatherDetails: List<WeatherDetails>, //description
    @field:Json(name = "wind") val wind: Wind, //wind
    @field:Json(name = "sys") val country: Country //sunset,sunrise
)