package com.hassanjamil.sampleandroidpostsapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Int,
    val title: String?,
    val body: String?,
    val userId: Int?,
    val isFavorite: Boolean = false,
)
