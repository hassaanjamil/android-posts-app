package com.hassanjamil.sampleandroidpostsapp.domain.repository

import com.hassanjamil.sampleandroidpostsapp.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPostById(postId: Int): Post
    suspend fun getFavoritePosts(): List<Post>
    suspend fun saveFavorite(post: Post)
    suspend fun deleteFavorite(postId: Int)
}
