package com.hassanjamil.sampleandroidpostsapp.navigation

import androidx.navigation3.runtime.NavKey
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.Post
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen : NavKey {
    @Serializable
    data object Home : Screen()

    @Serializable
    data class PostDetail(
        val post: Post
    ) : Screen()
}
