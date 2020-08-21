package github.sachin2dehury.weather.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import github.sachin2dehury.weather.R
import github.sachin2dehury.weather.location.locationValidator
import github.sachin2dehury.weather.settings.getUnit
import github.sachin2dehury.weather.settings.loadData
import github.sachin2dehury.weather.settings.saveData
import github.sachin2dehury.weather.ui.*

class SettingsFragment : PreferenceFragmentCompat() {

    private lateinit var editUnit: ListPreference
    private lateinit var zipCode: EditTextPreference
    private lateinit var countryCode: EditTextPreference

    @SuppressLint("DefaultLocale")
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        editUnit = findPreference("unit")!!
        zipCode = findPreference("zip")!!
        countryCode = findPreference("country")!!

        editUnit.setDefaultValue(tempUnit.unit)
        zipCode.setDefaultValue(zip)
        countryCode.setDefaultValue(country)

        editUnit.setOnPreferenceChangeListener{ _, newValue->
            tempUnit.unit = newValue.toString().toLowerCase()
            unit = getUnit()
            true
        }
        zipCode.setOnPreferenceChangeListener { _, newValue ->
            locationValidator(newValue.toString(), country, requireContext())
            true
        }
        countryCode.setOnPreferenceChangeListener { _, newValue ->
            locationValidator(zip, newValue.toString(), requireContext())
            true
        }
    }
    override fun onResume() {
        super.onResume()
        loadData(requireContext())
    }
    override fun onPause() {
        super.onPause()
        saveData(requireContext())
        currentForecast.getCurrentForecast(zip, country)
        weeklyForecast.getWeeklyForecast(pos.lat, pos.lon)
    }
}