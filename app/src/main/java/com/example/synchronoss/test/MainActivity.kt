package com.example.synchronoss.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.synchronoss.test.database.WeatherDatabase
import com.example.synchronoss.test.database.entity.WeatherEntity
import com.example.synchronoss.test.database.load_db.saveWeatherAPIResponse
import com.example.synchronoss.test.viewmodels.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mWeatherViewModel: WeatherViewModel
    lateinit var mViewModelFactory: ViewModelProvider.Factory
    private var isWeatherResponseSaved = false
    private lateinit var weatherDatabase: WeatherDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        mWeatherViewModel.getWeatherPeriodically()
    }


    private fun init() {
        weatherDatabase = WeatherDatabase(this)
        mWeatherViewModel = ViewModelProviders.of(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(WeatherViewModel::class.java)
        mWeatherViewModel.getWeatherDailyData()?.observe(this, Observer { weatherResponse ->
            if (weatherResponse != null) {
                isWeatherResponseSaved = saveWeatherAPIResponse(
                    weatherDatabase, weatherResponse
                )
            }

            if (isWeatherResponseSaved) {
                mWeatherViewModel.getWeatherFromDb(weatherDatabase)
            }
            Log.e("inserted", "saveWeatherAPIResponse : $isWeatherResponseSaved")
        })
        mWeatherViewModel.getWeatherFromDb(weatherDatabase)

        mWeatherViewModel.updateWeatherLiveData().observe(this, Observer { updatedWeatherResponse ->
            updateUI(updatedWeatherResponse)
        })

        mWeatherViewModel.getErrorLiveData().observe(this, Observer { errorResponse ->
            Log.e("insertion error", "saveWeatherAPIResponse ")
        })
    }

    /**
     * Method to update UI
     */
    private fun updateUI(updatedWeatherResponse: WeatherEntity) {

        cityName.text = updatedWeatherResponse.city_name
        temperature.text = updatedWeatherResponse.temp.toString()
        temperature_feels_like.text = updatedWeatherResponse.feels_like.toString()
        temperature_max.text = updatedWeatherResponse.temp_max.toString()
        temperature_min.text = updatedWeatherResponse.temp_min.toString()
        pressure.text = updatedWeatherResponse.pressure.toString()
        humidity.text = updatedWeatherResponse.humidity.toString()
        visibility.text = updatedWeatherResponse.visibility.toString()
        wind_speed.text = updatedWeatherResponse.speed.toString()


    }

    companion object {
        val TAG: String = "SynchWeatherAssign"
    }
}