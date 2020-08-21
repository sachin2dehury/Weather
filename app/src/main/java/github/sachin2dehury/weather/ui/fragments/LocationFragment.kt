package github.sachin2dehury.weather.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import github.sachin2dehury.weather.R
import github.sachin2dehury.weather.location.locationValidator
import github.sachin2dehury.weather.settings.loadData
import github.sachin2dehury.weather.ui.*
import kotlinx.android.synthetic.main.fragment_location.*

class LocationFragment : Fragment(R.layout.fragment_location) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (loadData(requireContext())) {
            zipCode.setText(zip)
            countryCode.setText(country)
        }

        locationEntryButton.setOnClickListener {
            if (locationValidator(zipCode.text.toString(), countryCode.text.toString(), requireContext())) {
                currentForecast.getCurrentForecast(zip, country)
                weeklyForecast.getWeeklyForecast(pos.lat, pos.lon)
                Toast.makeText(this.context,"Location Updated,Go Today/Week.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}