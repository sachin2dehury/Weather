package github.sachin2dehury.weather.api.data

import com.squareup.moshi.Json

data class WeeklyWeather(
    @field:Json(name = "daily") val weeklyForecast: List<DailyForecast>
)