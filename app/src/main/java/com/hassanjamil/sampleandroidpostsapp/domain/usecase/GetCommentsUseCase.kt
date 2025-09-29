package com.hassanjamil.sampleandroidpostsapp.domain.usecase

import com.hassanjamil.sampleandroidpostsapp.domain.model.Comment
import com.hassanjamil.sampleandroidpostsapp.domain.repository.CommentRepository

class GetCommentsUseCase(private val commentsRepository: CommentRepository) {
    suspend operator fun invoke(postId: Int): List<Comment> = commentsRepository.getComments(postId)
}
