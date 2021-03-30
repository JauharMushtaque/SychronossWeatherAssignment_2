package com.synchronoss.weather.viewmodel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.synchronoss.test.model.response.*
import com.example.synchronoss.test.viewmodels.WeatherViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class WeatherViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: WeatherViewModel


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = WeatherViewModel(application = Application())
    }

    @Test
    fun verifyLivedataChangesOnEvent() {
        viewModel.getWeatherDailyData()
        val result = viewModel.weatherMutableLiveData.getOrAwaitValue().apply {
            this.coord.lon == -6.2492 && this.coord.lat == 53.3551
        }
        assert(result != null)
    }


    fun provide_Weather_Base_Pojo_dummy_data(): Weather_Base_Pojo {
        return Weather_Base_Pojo(
            CoordResponse(-6.2492, 53.3551),
            listOf(WeatherResponse(802, "Clouds", "scattered clouds", "03d")),
            "stations",
            MainResponse(278.58f, 271.88f, 278.15f, 279.15f, 1026, 67),
            10000,
            WindResponse(6.7f, 110),
            CloudsResponse(75),
            1584786561,
            SysResponse(1, 1565, "IE", 1584771851, 1584815993),
            0,
            7778677,
            "Dublin City",
            200
        )
    }
}