package com.hassanjamil.sampleandroidpostsapp.domain.usecase

import com.hassanjamil.sampleandroidpostsapp.domain.model.Post
import com.hassanjamil.sampleandroidpostsapp.domain.repository.PostRepository

class GetPostsUseCase(private val postRepository: PostRepository) {
    suspend operator fun invoke(): List<Post> = postRepository.getPosts()
}
