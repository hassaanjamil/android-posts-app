package com.hassanjamil.sampleandroidpostsapp.data.repositories

import com.hassanjamil.sampleandroidpostsapp.data.db.PostDao
import com.hassanjamil.sampleandroidpostsapp.data.mapper.toData
import com.hassanjamil.sampleandroidpostsapp.data.mapper.toDomain
import com.hassanjamil.sampleandroidpostsapp.data.network.ApiService
import com.hassanjamil.sampleandroidpostsapp.domain.model.Post
import com.hassanjamil.sampleandroidpostsapp.domain.repository.PostRepository

class PostRepositoryImpl(
    private val apiService: ApiService,
    private val postDao: PostDao,
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        val remotePosts = apiService.getPosts().map { it.toDomain() }
        val favoriteMap = postDao.getFavoritePosts()
            .associateBy({ it.id }, { it.isFavorite })
        return remotePosts.map { post ->
            val isFavorite = favoriteMap[post.id] ?: false
            if (isFavorite) post.copy(isFavorite = true) else post
        }
    }

    override suspend fun getPostById(postId: Int): Post = apiService.getPostById(postId).toDomain()

    override suspend fun getFavoritePosts(): List<Post> = postDao.getFavoritePosts().map { it.toDomain() }

    override suspend fun saveFavorite(post: Post) {
        postDao.insert(post.toData().copy(isFavorite = true))
    }

    override suspend fun deleteFavorite(postId: Int) {
        postDao.deletePostById(postId)
    }
}
