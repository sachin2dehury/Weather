package github.sachin2dehury.weather.api

import com.squareup.moshi.Json

data class DailyWeatherDetails(
    val main: String,
    val description: String,
    val icon: String
)

data class DailyTempDetails(
    val day: Float,
    val night: Float,
    val min: Float,
    val max: Float
)

data class DailyForecast(
    @field:Json(name = "dt") val date: Long,
    @field:Json(name = "sunrise") val sunrise: Long,
    @field:Json(name = "sunset") val sunset: Long,
    @field:Json(name = "pressure") val pressure: Int,
    @field:Json(name = "humidity") val humidity: Int,
    @field:Json(name = "wind_speed") val wind_speed: Float,
    @field:Json(name = "wind_deg") val wind_deg: Int,
    @field:Json(name = "weather") val dailyWeatherDetails: List<DailyWeatherDetails>,
    @field:Json(name = "temp") val dailyTempDetails: DailyTempDetails
)

data class WeeklyWeather(
    @field:Json(name = "daily") val weeklyForecast: List<DailyForecast>
)