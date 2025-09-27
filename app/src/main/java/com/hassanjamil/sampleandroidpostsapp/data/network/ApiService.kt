package com.hassanjamil.sampleandroidpostsapp.data.network

import com.hassanjamil.sampleandroidpostsapp.data.model.Post
import com.hassanjamil.sampleandroidpostsapp.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path
@Suppress("unused")
interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Post

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): User
}
