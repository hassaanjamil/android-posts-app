@file:Suppress("unused")

package com.hassanjamil.sampleandroidpostsapp.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hassanjamil.sampleandroidpostsapp.data.model.Post

class PostTypeConverter {
    private val gson : Gson by lazy {
        Gson()
    }

    @TypeConverter
    fun fromPost(value: List<Post>): String = gson.toJson(value)

    @TypeConverter
    fun toPostList(value: String): List<Post> =
        gson.fromJson(value, object : TypeToken<List<Post>>() {}.type)
}
