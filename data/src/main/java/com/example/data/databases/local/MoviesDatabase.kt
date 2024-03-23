package com.example.data.databases.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


@Database(
    entities = [
        MoviesCacheModel::class,
    ],
    version = 2,
)
@TypeConverters(MoviesDatabase.Converters::class)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MoviesDao
    object Converters{
        @TypeConverter
        fun fromString(value: String?) : List<String> {
            val listType: Type = object : TypeToken<List<String?>?>() {}.type
            return Gson().fromJson(value, listType)
        }
        @TypeConverter
        fun fromList(list: List<String?>?) : String {
            val gson= Gson()
            return gson.toJson(list)
        }
    }
}