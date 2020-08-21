package github.sachin2dehury.weather.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import github.sachin2dehury.weather.R
import github.sachin2dehury.weather.settings.loadData
import github.sachin2dehury.weather.settings.saveData
import github.sachin2dehury.weather.ui.fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationFragment = LocationFragment()
        val currentWeatherFragment = CurrentWeatherFragment()
        val weeklyWeatherFragment = WeeklyWeatherFragment()

        bottomNavigationView.selectedItemId = R.id.bottomLocation
        setFragment(locationFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener { view ->
            try {
                when (view.itemId) {
                    R.id.bottomCurrentWeather -> setFragment(currentWeatherFragment)
                    R.id.bottomWeeklyWeather -> setFragment(weeklyWeatherFragment)
                    R.id.bottomLocation -> setFragment(locationFragment)
                }
            } catch (e: UninitializedPropertyAccessException) {
                Toast.makeText(this, "${e.toString()} Error Occurred!", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment, addToStack: Boolean = true) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.navigationFragment, fragment)
            addToBackStack(fragment.javaClass.toString())
//            Log.d("Sachin",fragment.javaClass.toString())
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                setFragment(SettingsFragment())
                true
            }
            R.id.about -> {
                setFragment(AboutFragment())
                true
            }
            R.id.exit -> exitProcess(0)
            else -> false
        }
    }

    override fun onResume() {
        super.onResume()
        loadData(this)
    }

    override fun onPause() {
        super.onPause()
        saveData(this)
    }
}