package com.hassanjamil.sampleandroidpostsapp.domain.usecase

import com.hassanjamil.sampleandroidpostsapp.domain.model.Post
import com.hassanjamil.sampleandroidpostsapp.domain.repository.PostRepository

class ToggleFavoritePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(post: Post, markAsFavorite: Boolean) {
        if (markAsFavorite) {
            postRepository.saveFavorite(post.copy(isFavorite = true))
        } else {
            postRepository.deleteFavorite(post.id)
        }
    }
}
