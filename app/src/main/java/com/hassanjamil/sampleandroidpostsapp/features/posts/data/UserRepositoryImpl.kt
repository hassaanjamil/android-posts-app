package com.hassanjamil.sampleandroidpostsapp.features.posts.data

import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.User
import com.hassanjamil.sampleandroidpostsapp.network.ApiService

class UserRepositoryImpl(private val apiService: ApiService) : UserRepository {
    override suspend fun getUserById(userId: Int): User = apiService.getUserById(userId)
}
