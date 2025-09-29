package com.hassanjamil.sampleandroidpostsapp.domain.repository

import com.hassanjamil.sampleandroidpostsapp.domain.model.Comment

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}
