package com.hassanjamil.sampleandroidpostsapp.features.posts.data

import com.hassanjamil.sampleandroidpostsapp.features.posts.data.serializables.Post
import com.hassanjamil.sampleandroidpostsapp.service.ApiService
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val apiService: ApiService): PostRepository {
    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts()
    }

    override suspend fun getPostById(postId: Int): Post {
        return apiService.getPostById(postId)
    }

}
