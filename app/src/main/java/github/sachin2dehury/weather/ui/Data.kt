package github.sachin2dehury.weather.ui

import android.annotation.SuppressLint
import github.sachin2dehury.weather.BuildConfig
import github.sachin2dehury.weather.api.CoOrdinates
import github.sachin2dehury.weather.api.createApiService
import github.sachin2dehury.weather.forecast.CurrentForecast
import github.sachin2dehury.weather.forecast.WeeklyForecast
import github.sachin2dehury.weather.settings.AllUnits
import github.sachin2dehury.weather.settings.TempUnit
import github.sachin2dehury.weather.settings.getUnit
import java.text.SimpleDateFormat

var zip: String = "98101"
var country: String = "US"
val apiService = createApiService()
var tempUnit = TempUnit()
val allUnits = AllUnits()
const val apiKey = BuildConfig.API_KEY
lateinit var pos: CoOrdinates
lateinit var loc: String
var unit = getUnit()

val currentForecast = CurrentForecast()
val weeklyForecast = WeeklyForecast()

@SuppressLint("SimpleDateFormat")
val dateFormat = SimpleDateFormat("dd-MM-yyyy")

@SuppressLint("SimpleDateFormat")
val timeFormat = SimpleDateFormat("hh:mm:ss aa")