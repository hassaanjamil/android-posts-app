package com.hassanjamil.sampleandroidpostsapp.data.repositories

import com.hassanjamil.sampleandroidpostsapp.data.model.Post
import com.hassanjamil.sampleandroidpostsapp.data.network.ApiService

class PostRepositoryImpl(private val apiService: ApiService) : PostRepository {
    override suspend fun getPosts(): List<Post> = apiService.getPosts()

    override suspend fun getPostById(postId: Int): Post = apiService.getPostById(postId)
}
