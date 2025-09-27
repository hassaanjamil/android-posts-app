package com.hassanjamil.sampleandroidpostsapp.features.posts.data

import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.User

interface UserRepository {
    suspend fun getUserById(userId: Int): User
}
