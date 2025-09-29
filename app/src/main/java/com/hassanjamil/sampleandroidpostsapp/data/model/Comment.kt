package com.hassanjamil.sampleandroidpostsapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: Int? = null,
    val body: String? = null,
    val userId: Int? = null,
    val postId: Int? = null
)
