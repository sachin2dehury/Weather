package github.sachin2dehury.weather.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import github.sachin2dehury.weather.BuildConfig
import github.sachin2dehury.weather.R
import kotlinx.android.synthetic.main.fragment_about.*


class AboutFragment : Fragment(R.layout.fragment_about) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aboutText.text = "Developed By : Sachin Dehury\nEmail : sachindehury2015@gmail.com\nVersion : ${BuildConfig.VERSION_NAME}\nBuild Date : 21.08.2020"
    }
}