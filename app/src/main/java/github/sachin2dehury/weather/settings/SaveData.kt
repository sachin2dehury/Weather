package github.sachin2dehury.weather.settings

import android.content.Context
import androidx.preference.PreferenceManager
import github.sachin2dehury.weather.api.CoOrdinates
import github.sachin2dehury.weather.ui.*

private const val app = "github.sachin2dehury.weather"

fun saveData(context: Context) {
    PreferenceManager.getDefaultSharedPreferences(context).edit().apply {
        putInt(app, 1)
        putString("zip", zip)
        putString(
            "country",
            country
        )
        putFloat("lat", pos.lat)
        putFloat("lon", pos.lon)
        putString("unit", tempUnit.unit)
        putString("loc", loc)
        apply()
    }
//    Log.d("Sachin","Committed ${context.javaClass} ${tempUnit.unit}")
}

fun loadData(context: Context): Boolean {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    if (sharedPreferences.contains(app)) {
        zip = sharedPreferences.getString("zip", "751018")!!
        country = sharedPreferences.getString("country", "IN")!!
        val lat = sharedPreferences.getFloat("lat", 0f)
        val lon = sharedPreferences.getFloat("lon", 0f)
        pos = CoOrdinates(lon, lat)
        tempUnit.unit = sharedPreferences.getString("unit", tempUnit.unit)!!
        loc = sharedPreferences.getString("loc", "")!!
        unit = getUnit()
//        Log.d("Sachin","Loaded ${context.javaClass} ${tempUnit.unit}")
        return true
    }
    return false
}