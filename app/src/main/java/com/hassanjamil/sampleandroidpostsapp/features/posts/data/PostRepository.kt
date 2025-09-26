package com.hassanjamil.sampleandroidpostsapp.features.posts.data

import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPostById(postId: Int): Post
}
