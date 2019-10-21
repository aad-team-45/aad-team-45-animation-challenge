package com.rockokechukwu.e_bookrecomender.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rockokechukwu.e_bookrecomender.api.response.Ebook
import com.rockokechukwu.e_bookrecomender.api.response.Ebook.VolumeInfo
import java.util.*

class IndustryIdentifiersConverter {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): MutableList<VolumeInfo.IndustryIdentifiers> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<VolumeInfo.IndustryIdentifiers>>() {

        }.type

        return gson.fromJson<MutableList<VolumeInfo.IndustryIdentifiers>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: MutableList<VolumeInfo.IndustryIdentifiers>): String {
        return gson.toJson(someObjects)
    }
}




class OtherTypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<String> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<String>>() {

        }.type

        return gson.fromJson<List<String>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<String>): String {
        return gson.toJson(someObjects)
    }

}