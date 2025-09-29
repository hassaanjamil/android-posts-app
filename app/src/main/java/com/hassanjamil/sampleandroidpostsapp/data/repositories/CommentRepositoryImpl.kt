package com.hassanjamil.sampleandroidpostsapp.data.repositories

import com.hassanjamil.sampleandroidpostsapp.data.mapper.toDomain
import com.hassanjamil.sampleandroidpostsapp.data.network.ApiService
import com.hassanjamil.sampleandroidpostsapp.domain.model.Comment
import com.hassanjamil.sampleandroidpostsapp.domain.repository.CommentRepository

class CommentRepositoryImpl(
    private val apiService: ApiService,
): CommentRepository {
    override suspend fun getComments(postId: Int): List<Comment> {
        val comments = apiService.getComments(postId).map { it.toDomain() }
        return if(comments.isEmpty()) emptyList() else comments
    }
}
