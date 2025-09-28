package com.hassanjamil.sampleandroidpostsapp.presentation.navigation.model

import androidx.navigation3.runtime.NavKey
import com.hassanjamil.sampleandroidpostsapp.data.model.Post
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen: NavKey {
    @Serializable
    data object Auth : Screen()

    @Serializable
    data object NestedGraph : Screen()

    @Serializable
    data object Profile : Screen()

    @Serializable
    data class PostDetail(val post: Post) : Screen()
}
