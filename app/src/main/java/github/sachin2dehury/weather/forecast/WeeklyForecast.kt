package github.sachin2dehury.weather.forecast

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import github.sachin2dehury.weather.api.WeeklyWeather
import github.sachin2dehury.weather.ui.apiKey
import github.sachin2dehury.weather.ui.apiService
import github.sachin2dehury.weather.ui.tempUnit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeeklyForecast() {

    private val exclude = "current,minutely,hourly"

    private val _weeklyForecast = MutableLiveData<WeeklyWeather>()
    val weeklyForecast: LiveData<WeeklyWeather> = _weeklyForecast

    fun getWeeklyForecast(lat: Float, lon: Float) {

        val call = apiService.getWeeklyForecast(
            lat, lon, exclude,
            apiKey,
            tempUnit.unit
        )

        call.enqueue(object : Callback<WeeklyWeather> {

            override fun onFailure(call: Call<WeeklyWeather>, t: Throwable) {
                Log.e(WeeklyForecast::class.java.simpleName, "error loading current weather", t)
            }

            override fun onResponse(call: Call<WeeklyWeather>, response: Response<WeeklyWeather>) {
                val weeklyWeatherResponse = response.body()
                if (weeklyWeatherResponse != null) {
                    _weeklyForecast.value = weeklyWeatherResponse
//                    Log.d("WeeklyWeatherResponse", weeklyWeatherResponse.toString())
                } else {
                    Log.e(WeeklyForecast::class.java.simpleName, "Error! Null Weekly Weather")
                }
            }
        })
    }
}