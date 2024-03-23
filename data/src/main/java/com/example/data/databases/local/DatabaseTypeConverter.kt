package com.example.data.databases.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DatabaseTypeConverter {
    @TypeConverter
    fun toStorage(elements: List<String>?): String? {
        if (elements == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<String>?>() {}.type
        return gson.toJson(elements, type)
    }

    @TypeConverter
    fun fromStorage(elements: String?): List<String>? {
        if (elements == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<String>?>() {}.type
        return gson.fromJson(elements, type)
    }
}