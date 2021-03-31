package com.example.synchronoss.test.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.synchronoss.test.database.WeatherDatabase
import com.example.synchronoss.test.database.entity.WeatherEntity
import com.example.synchronoss.test.model.WeatherRepository
import com.example.synchronoss.test.model.response.Weather_Base_Pojo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class WeatherViewModel (application: Application) : AndroidViewModel(application)  {
    var weatherMutableLiveData = MutableLiveData<Weather_Base_Pojo>()
    private val _dataLoading = MutableLiveData<Boolean>()
    var repository: WeatherRepository
    private lateinit var disposable: Disposable
    private val mUpdateWeatherLiveData = MutableLiveData<WeatherEntity>()
    private val mErrorLiveData = MutableLiveData<String>()

    init {
        _dataLoading.value = true
        repository = WeatherRepository()
        _dataLoading.postValue(true)
        weatherMutableLiveData = repository.getWeatherDailyResponseLiveData() as MutableLiveData<Weather_Base_Pojo>
        _dataLoading.postValue(false)
    }

    /**
     * getWeather for the every 2 hours
     */
    fun getWeatherEveryTwoHours() {
        disposable = Observable.interval(
            0, 2,
            TimeUnit.HOURS
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ this.getWeatherDailyData() }, { this.onError() })
    }

    /**
     * Method to load the weather data
     */
    fun getWeatherFromDb(weatherDatabase: WeatherDatabase) {
        GlobalScope.launch {
            val weatherEntity: WeatherEntity? =
                weatherDatabase.weatherDao().getWeather()

            withContext(Dispatchers.Main) {
                mUpdateWeatherLiveData.value = weatherEntity
            }
        }
    }

    fun getWeatherDailyData() = weatherMutableLiveData

    /**
     * Method to observe changes in Weather live data
     */
    fun updateWeatherLiveData() = mUpdateWeatherLiveData

    /**
     * Method to observe changes in error live data
     */
    fun getErrorLiveData() = mErrorLiveData

    protected fun onError() {
        Log.d("WeatherViewModel", "OnError in Observable Timer")
    }

    override fun onCleared() {
        super.onCleared()
        if (!disposable.isDisposed) disposable.dispose()
    }
}