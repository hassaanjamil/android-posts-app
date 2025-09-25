package com.hassanjamil.sampleandroidpostsapp.service

import com.hassanjamil.sampleandroidpostsapp.posts.data.Post
import com.hassanjamil.sampleandroidpostsapp.posts.data.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Post

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): User
}
