package com.hassanjamil.sampleandroidpostsapp.data.repositories

import com.hassanjamil.sampleandroidpostsapp.data.mapper.toDomain
import com.hassanjamil.sampleandroidpostsapp.data.network.ApiService
import com.hassanjamil.sampleandroidpostsapp.domain.model.User
import com.hassanjamil.sampleandroidpostsapp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val apiService: ApiService
) : UserRepository {
    override suspend fun getUserById(userId: Int): User = apiService.getUserById(userId).toDomain()
}
