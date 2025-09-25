package com.hassanjamil.sampleandroidpostsapp.posts.data

data class Post(
    val id: Int,
    val title: String? = null,
    val body: String? = null,
    val userId: Int? = null,
)
