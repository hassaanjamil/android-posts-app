package com.hassanjamil.sampleandroidpostsapp.presentation.navigation.model

import androidx.navigation3.runtime.NavKey
import com.hassanjamil.sampleandroidpostsapp.domain.model.Post
import kotlinx.serialization.Serializable

@Serializable
sealed class RootScreen : NavKey {
    @Serializable
    data object Auth : RootScreen()

    @Serializable
    data object NestedBottomBarGraph : RootScreen()

    @Serializable
    data object Profile : RootScreen()

    @Serializable
    data class PostDetail(val post: Post) : RootScreen()
}
