package com.enghack2018.Model

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: ArrayList<String>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): ArrayList<String>? {
        val objects = Gson().fromJson(value, Array<String>::class.java) as Array<String>
        return ArrayList<String>().apply { addAll(objects) }
    }
}