package com.example.synchronoss.test.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.*
import androidx.room.RoomDatabase
import com.example.synchronoss.test.database.dao.WeatherDao
import com.example.synchronoss.test.database.entity.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        var TEST_MODE = false
        @Volatile
        private var instance: WeatherDatabase? = null
        private val LOCK = Any()


        open operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: initDatabase(context).also { instance = it }
        }

        fun initDatabase(context: Context): WeatherDatabase {
            if (TEST_MODE) {
                return Room.inMemoryDatabaseBuilder(context, WeatherDatabase::class.java)
                    .allowMainThreadQueries().build()
            } else {
                return Room.databaseBuilder(
                    context,
                    WeatherDatabase::class.java, "weather-database.db"
                )
                    .build()
            }
        }
    }
}