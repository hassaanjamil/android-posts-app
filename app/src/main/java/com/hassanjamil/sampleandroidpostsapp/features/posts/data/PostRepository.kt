package com.hassanjamil.sampleandroidpostsapp.features.posts.data

import com.hassanjamil.sampleandroidpostsapp.features.posts.data.serializables.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPostById(postId: Int): Post
}
