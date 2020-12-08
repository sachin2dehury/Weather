package github.sachin2dehury.weather.api.data

data class TempDetails(
    val temp: Float, val feels_like: Float, val temp_min: Float, val temp_max: Float,
    val pressure: Int, val humidity: Int
)