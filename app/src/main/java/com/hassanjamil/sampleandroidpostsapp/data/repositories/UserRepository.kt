package com.hassanjamil.sampleandroidpostsapp.data.repositories

import com.hassanjamil.sampleandroidpostsapp.data.model.User

interface UserRepository {
    suspend fun getUserById(userId: Int): User
}
