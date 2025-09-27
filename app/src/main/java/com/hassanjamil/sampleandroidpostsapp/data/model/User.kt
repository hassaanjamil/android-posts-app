package com.hassanjamil.sampleandroidpostsapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int? = null,
    val username: String? = null,
    val name: String? = null
)
