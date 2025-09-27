package com.hassanjamil.sampleandroidpostsapp.data.repositories

import com.hassanjamil.sampleandroidpostsapp.data.network.ApiService
import com.hassanjamil.sampleandroidpostsapp.data.model.User

class UserRepositoryImpl(private val apiService: ApiService) : UserRepository {
    override suspend fun getUserById(userId: Int): User = apiService.getUserById(userId)
}
