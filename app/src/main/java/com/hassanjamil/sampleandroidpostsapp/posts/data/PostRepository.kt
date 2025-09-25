package com.hassanjamil.sampleandroidpostsapp.posts.data

import com.hassanjamil.sampleandroidpostsapp.posts.data.serializables.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPostById(postId: Int): Post
}
