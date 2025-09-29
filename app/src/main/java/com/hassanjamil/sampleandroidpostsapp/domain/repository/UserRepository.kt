package com.hassanjamil.sampleandroidpostsapp.domain.repository

import com.hassanjamil.sampleandroidpostsapp.domain.model.User

interface UserRepository {
    suspend fun getUserById(id: Int): User
}
