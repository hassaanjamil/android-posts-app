package com.hassanjamil.sampleandroidpostsapp.data.repositories

import com.hassanjamil.sampleandroidpostsapp.data.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPostById(postId: Int): Post
}
