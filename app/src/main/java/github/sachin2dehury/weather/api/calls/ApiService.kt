package github.sachin2dehury.weather.api.calls

import github.sachin2dehury.weather.api.data.CurrentWeather
import github.sachin2dehury.weather.api.data.WeeklyWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/data/2.5/weather")
    fun getCurrentWeather(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String,
        @Query("units") unit: String
    ): Call<CurrentWeather>


    @GET("/data/2.5/onecall")
    fun getWeeklyForecast(
        @Query("lat") lat: Float,
        @Query("lon") lon: Float,
        @Query("exclude") exclude: String,
        @Query("appid") apiKey: String,
        @Query("units") unit: String
    ): Call<WeeklyWeather>
}