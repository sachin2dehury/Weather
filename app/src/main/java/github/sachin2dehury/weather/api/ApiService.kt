package github.sachin2dehury.weather.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
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

fun createApiService(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://api.openweathermap.org")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    return retrofit.create(ApiService::class.java)
}