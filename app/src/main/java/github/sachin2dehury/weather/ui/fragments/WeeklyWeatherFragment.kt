package github.sachin2dehury.weather.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import github.sachin2dehury.weather.R
import github.sachin2dehury.weather.adapters.WeeklyListAdapter
import github.sachin2dehury.weather.api.data.WeeklyWeather
import github.sachin2dehury.weather.others.Constants.pos
import github.sachin2dehury.weather.others.Constants.weeklyForecast
import kotlinx.android.synthetic.main.fragment_weekly_weather.*

class WeeklyWeatherFragment : Fragment(R.layout.fragment_weekly_weather) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weeklyList.layoutManager = LinearLayoutManager(context)

        val weeklyForecastObserver = Observer<WeeklyWeather> {
            val weeklyListAdapter =
                WeeklyListAdapter(
                    weeklyForecast.weeklyForecast.value!!.weeklyForecast,
                    parentFragmentManager
                )
            weeklyList.adapter = weeklyListAdapter
            progressBar.visibility = View.GONE
        }

        weeklyForecast.weeklyForecast.observe(viewLifecycleOwner, weeklyForecastObserver)

        weeklyForecast.getWeeklyForecast(pos.lat, pos.lon)
    }

}