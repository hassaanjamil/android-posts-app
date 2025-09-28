package com.hassanjamil.sampleandroidpostsapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "Post")
data class Post(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("userId")
    val userId: Int
)
