package github.sachin2dehury.weather.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import github.sachin2dehury.weather.R
import github.sachin2dehury.weather.api.WeeklyWeather
import github.sachin2dehury.weather.ui.*
import github.sachin2dehury.weather.ui.helper.index
import kotlinx.android.synthetic.main.fragment_weekly_details.*
import java.util.*

class WeeklyDetailsFragment : Fragment(R.layout.fragment_weekly_details) {

    @SuppressLint("SetTextI18n", "DefaultLocale")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weeklyDetailsObserver = Observer<WeeklyWeather> { data ->

            if (data == null) {
//                finish()
                Toast.makeText(context, "Invalid Location", Toast.LENGTH_SHORT).show()
            }
            val img =
                "http://openweathermap.org/img/wn/${data.weeklyForecast[index].dailyWeatherDetails[0].icon}@4x.png"
            Picasso.get().load(img).into(icon)
            description.text =
                "Mood : ${data.weeklyForecast[index].dailyWeatherDetails[0].description.capitalize()}"
            desc.text = data.weeklyForecast[index].dailyWeatherDetails[0].main.capitalize()
            date.text = dateFormat.format(Date(data.weeklyForecast[index].date * 1000))
            tempDay.text = "Day Temp : ${data.weeklyForecast[index].dailyTempDetails.day} $unit"
            tempNight.text =
                "Night Temp :${data.weeklyForecast[index].dailyTempDetails.night} $unit"
            tempMax.text = "Max Temp :${data.weeklyForecast[index].dailyTempDetails.max} $unit"
            tempMin.text = "Min Temp :${data.weeklyForecast[index].dailyTempDetails.min} $unit"
            pressure.text = "Pressure : ${data.weeklyForecast[index].pressure} ${allUnits.pressure}"
            humidity.text = "Humidity : ${data.weeklyForecast[index].humidity} ${allUnits.humidity}"
            sunrise.text =
                "Sun Rise : ${timeFormat.format(Date(data.weeklyForecast[index].sunrise * 1000))}"
            sunset.text =
                "Sun Set : ${timeFormat.format(Date(data.weeklyForecast[index].sunset * 1000))}"
            windSpeed.text =
                "Wind Speed : ${data.weeklyForecast[index].wind_speed} ${allUnits.speed}"
            windDirection.text =
                "Direction : ${data.weeklyForecast[index].wind_deg} ${allUnits.degree}"
            location.text = loc

            progressBar.visibility = View.GONE
        }

        weeklyForecast.weeklyForecast.observe(viewLifecycleOwner, weeklyDetailsObserver)

    }
}