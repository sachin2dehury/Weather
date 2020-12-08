package github.sachin2dehury.weather.forecast

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import github.sachin2dehury.weather.api.data.CurrentWeather
import github.sachin2dehury.weather.others.Constants.apiKey
import github.sachin2dehury.weather.others.Constants.apiService
import github.sachin2dehury.weather.others.Constants.tempUnit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentForecast {

    private val _currentForecast = MutableLiveData<CurrentWeather>()
    val currentForecast: LiveData<CurrentWeather> = _currentForecast

    fun getCurrentForecast(zip: String, country: String) = CoroutineScope(Dispatchers.IO).launch {

        val call = apiService.getCurrentWeather(
            "$zip,$country",
            apiKey, tempUnit.unit
        )

        call.enqueue(object : Callback<CurrentWeather> {
            override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                Log.e(
                    CurrentForecast::class.java.simpleName,
                    "Error! Loading Current Weather from Internet",
                    t
                )
            }

            override fun onResponse(
                call: Call<CurrentWeather>,
                response: Response<CurrentWeather>
            ) {
                val weatherResponse = response.body()
                if (weatherResponse != null) {
                    _currentForecast.value = weatherResponse
//                    Log.d("WeatherResponse", weatherResponse.toString())
                } else {
                    Log.e(CurrentForecast::class.java.simpleName, "Error! Null Current Weather")
                }
            }
        })
    }
}