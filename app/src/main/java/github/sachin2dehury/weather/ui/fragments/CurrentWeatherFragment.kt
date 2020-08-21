package github.sachin2dehury.weather.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import github.sachin2dehury.weather.R
import github.sachin2dehury.weather.api.CurrentWeather
import github.sachin2dehury.weather.settings.saveData
import github.sachin2dehury.weather.ui.*
import kotlinx.android.synthetic.main.fragment_current_weather.*
import java.util.*

class CurrentWeatherFragment : Fragment(R.layout.fragment_current_weather) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentForecastObserver = Observer<CurrentWeather> { data ->

            if (data == null) {
//                context.finish()
//                Toast.makeText(context, "Invalid Location", Toast.LENGTH_SHORT).show()
                Log.d("Sachin","NO DATA ${this.javaClass}")
            }

            val img = "http://openweathermap.org/img/wn/${data.weatherDetails[0].icon}@4x.png"
            Picasso.get().load(img).into(icon)
            description.text = "Mood : ${data.weatherDetails[0].description.capitalize()}"
            desc.text = data.weatherDetails[0].main.capitalize()
            date.text = dateFormat.format(Date(data.date * 1000))
            temp.text = "Temp : ${data.tempDetails.temp} $unit"
            feelsLike.text = "Feels Like :${data.tempDetails.feels_like} $unit"
            tempMax.text = "Max Temp :${data.tempDetails.temp_max} $unit"
            tempMin.text = "Min Temp :${data.tempDetails.temp_min} $unit"
            pressure.text = "Pressure : ${data.tempDetails.pressure} ${allUnits.pressure}"
            humidity.text = "Humidity : ${data.tempDetails.humidity} ${allUnits.humidity}"
            location.text = data.location
            sunrise.text = "Sun Rise : ${timeFormat.format(Date(data.country.sunrise * 1000))}"
            sunset.text = "Sun Set : ${timeFormat.format(Date(data.country.sunset * 1000))}"
            windSpeed.text = "Wind Speed : ${data.wind.speed} ${allUnits.speed}"
            windDirection.text = "Direction : ${data.wind.deg} ${allUnits.degree}"

            pos = data.position
            loc = data.location

            progressBar.visibility = View.GONE
        }

        currentForecast.currentForecast.observe(viewLifecycleOwner, currentForecastObserver)

        currentForecast.getCurrentForecast(
            zip,
            country
        )

    }

    override fun onPause() {
        super.onPause()
        context?.let { context -> saveData(context) }
    }
}