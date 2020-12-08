package github.sachin2dehury.weather.location

import android.content.Context
import android.widget.Toast

fun locationValidator(zipText: String, countryText: String, context: Context): Boolean {

    when {
        (!(zipText.length >= 5 || zipText.length <= 6)) -> {
            Toast.makeText(context, "Invalid Zip Code", Toast.LENGTH_SHORT).show()
        }
        countryText.length != 2 -> {
            Toast.makeText(context, "Invalid Country Code", Toast.LENGTH_SHORT).show()
        }
        else -> {
            zip = zipText
            country = countryText
            return true
        }
    }
    return false
}
