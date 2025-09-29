package com.hassanjamil.sampleandroidpostsapp.domain.usecase

import com.hassanjamil.sampleandroidpostsapp.domain.model.User
import com.hassanjamil.sampleandroidpostsapp.domain.repository.UserRepository

class GetUserByIdUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(userId: Int): User = userRepository.getUserById(userId)
}
