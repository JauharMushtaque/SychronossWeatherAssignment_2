package com.example.synchronoss.test

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.synchronoss.test.database.WeatherDatabase
import com.example.synchronoss.test.database.entity.WeatherEntity
import com.example.synchronoss.test.database.load_db.saveWeatherDataInDatabase
import com.example.synchronoss.test.utils.Utility
import com.example.synchronoss.test.viewmodels.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mWeatherViewModel: WeatherViewModel
    private var isWeatherResponseSaved = false
    private lateinit var weatherDatabase: WeatherDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWeatherData()
        mWeatherViewModel.getWeatherEveryTwoHours()
    }

    private fun setupWeatherData() {
        weatherDatabase = WeatherDatabase(this)
        mWeatherViewModel = ViewModelProviders.of(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(WeatherViewModel::class.java)
        mWeatherViewModel.getWeatherDailyData().observe(this, Observer { weatherResponse ->
            weatherResponse?.let{
                isWeatherResponseSaved = saveWeatherDataInDatabase(
                    weatherDatabase, weatherResponse
                )
                Log.e("inserted", "saveWeatherAPIResponse : $isWeatherResponseSaved")
                getWeatherDataFromDB(isWeatherResponseSaved)
            }
        })

        getWeatherDataFromDB(isWeatherResponseSaved)

        mWeatherViewModel.updateWeatherLiveData().observe(this, Observer { updatedWeatherResponse ->
            updateUI(updatedWeatherResponse)
        })

        mWeatherViewModel.getErrorLiveData().observe(this, Observer { errorResponse ->
            Log.e("insertion error", "saveWeatherAPIResponse ")
        })
    }

    private fun getWeatherDataFromDB(isWeatherResponseSaved: Boolean){
        if (isWeatherResponseSaved) {
            mWeatherViewModel.getWeatherFromDb(weatherDatabase)
        }else if(!Utility.isNetworkAvailable(this)){
            mWeatherViewModel.getWeatherFromDb(weatherDatabase)
        }
    }

    /**
     * Method to update UI
     */
    @SuppressLint("SetTextI18n")
    private fun updateUI(updatedWeatherResponse: WeatherEntity) {
        setWeatherTypeFaceFont()

        cityName.text = updatedWeatherResponse.city_name
//        temperature.text = updatedWeatherResponse.temp.toString()
        temperature.text = updatedWeatherResponse.temp.toString()+"\u00B0"
        temperature_feels_like.text = updatedWeatherResponse.feels_like.toString()+"\u00B0"
        temperature_max.text = updatedWeatherResponse.temp_max.toString()+"\u00B0"
        temperature_min.text = updatedWeatherResponse.temp_min.toString()+"\u00B0"
        pressure.text = updatedWeatherResponse.pressure.toString()
        humidity.text = updatedWeatherResponse.humidity.toString()
        visibility.text = updatedWeatherResponse.visibility.toString()
        wind_speed.text = updatedWeatherResponse.speed.toString()
    }

    /**
     * Method to set Typeface
     */
    private fun setWeatherTypeFaceFont(){
        val weatherFont= Typeface.createFromAsset(this.assets, "font/weather.ttf")

        cityName.setTypeface(weatherFont)
        temperature.setTypeface(weatherFont)
        temperature_feels_like.setTypeface(weatherFont)
        temperature_max.setTypeface(weatherFont)
        temperature_min.setTypeface(weatherFont)
        pressure.setTypeface(weatherFont)
        humidity.setTypeface(weatherFont)
        visibility.setTypeface(weatherFont)
        wind_speed.setTypeface(weatherFont)

        cityName_label.setTypeface(weatherFont)
        temperature_label.setTypeface(weatherFont)
        temperature_feels_like_label.setTypeface(weatherFont)
        temperature_min_label.setTypeface(weatherFont)
        temperature_max_label.setTypeface(weatherFont)
        pressure_label.setTypeface(weatherFont)
        humidity_label.setTypeface(weatherFont)
        visibility_label.setTypeface(weatherFont)
        wind_speed_label.setTypeface(weatherFont)
    }

    companion object {
        val TAG: String = "SynchWeatherAssign"
    }
}