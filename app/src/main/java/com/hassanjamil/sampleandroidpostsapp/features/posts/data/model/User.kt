package com.hassanjamil.sampleandroidpostsapp.features.posts.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int? = null,
    val username: String? = null,
    val name: String? = null
)
