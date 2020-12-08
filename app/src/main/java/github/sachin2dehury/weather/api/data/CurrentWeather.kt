package github.sachin2dehury.weather.api.data

import com.squareup.moshi.Json

data class CurrentWeather(
    @field:Json(name = "dt") val date: Long, //date
    @field:Json(name = "name") val location: String, //location
    @field:Json(name = "coord") val position: CoOrdinates, //position
    @field:Json(name = "main") val tempDetails: TempDetails, //temp
    @field:Json(name = "weather") val weatherDetails: List<WeatherDetails>, //description
    @field:Json(name = "wind") val wind: Wind, //wind
    @field:Json(name = "sys") val country: Country //sunset,sunrise
)