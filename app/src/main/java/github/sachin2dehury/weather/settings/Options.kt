package github.sachin2dehury.weather.settings

import github.sachin2dehury.weather.ui.tempUnit

data class TempUnit(var unit: String = "metric")

data class AllUnits(
    val pressure: String = "atm",
    val speed: String = "m/s",
    val degree: String = "°",
    val humidity: String = "%"
)

fun getUnit(): String {
//    Log.d("Sachin","Get Unit Called ${tempUnit.unit}")
    return when (tempUnit.unit) {
        "metric" -> "°C"
        "default" -> "K"
        "imperial" -> "°F"
        else -> "K"
    }
}