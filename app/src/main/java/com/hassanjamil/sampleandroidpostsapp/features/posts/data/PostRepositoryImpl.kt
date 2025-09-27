package com.hassanjamil.sampleandroidpostsapp.features.posts.data

import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.Post
import com.hassanjamil.sampleandroidpostsapp.network.ApiService

class PostRepositoryImpl(private val apiService: ApiService) : PostRepository {
    override suspend fun getPosts(): List<Post> = apiService.getPosts()

    override suspend fun getPostById(postId: Int): Post = apiService.getPostById(postId)
}
