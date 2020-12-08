package github.sachin2dehury.weather.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import github.sachin2dehury.weather.R
import github.sachin2dehury.weather.api.data.DailyForecast
import github.sachin2dehury.weather.others.Constants.dateFormat
import github.sachin2dehury.weather.others.Constants.unit
import github.sachin2dehury.weather.ui.fragments.WeeklyDetailsFragment
import kotlinx.android.synthetic.main.list_item_layout.view.*
import java.util.*

class WeeklyListAdapter(
    private val weatherList: List<DailyForecast>,
    private val fragmentManager: FragmentManager
) :
    RecyclerView.Adapter<WeeklyListAdapter.WeeklyViewHolder>() {

    inner class WeeklyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeeklyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return WeeklyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onBindViewHolder(holder: WeeklyViewHolder, position: Int) {
        holder.itemView.apply {
            val dailyForecast = weatherList[position]
            val img =
                "http://openweathermap.org/img/wn/${dailyForecast.dailyWeatherDetails[0].icon}@2x.png"
            Picasso.get().load(img).into(icon)
            date.text = dateFormat.format(Date(dailyForecast.date * 1000))
            desc.text = dailyForecast.dailyWeatherDetails[0].main.capitalize()
            tempDay.text = "${dailyForecast.dailyTempDetails.max} $unit"
            setOnClickListener {
                fragmentManager.beginTransaction().apply {
                    replace(R.id.navigationFragment, WeeklyDetailsFragment())
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }
}