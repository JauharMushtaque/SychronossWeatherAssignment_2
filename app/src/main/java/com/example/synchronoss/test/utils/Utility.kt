@file:Suppress("DEPRECATION")

package com.example.synchronoss.test.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object  Utility {
    const val BASE_URL = "https://api.openweathermap.org/"

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }

    fun convertToCelcius(temp: String):String{
        val test = temp.toFloat()-273.15
        return "%.2f".format(test)
    }
}