package com.hassanjamil.sampleandroidpostsapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.scene.rememberSceneSetupNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.hassanjamil.sampleandroidpostsapp.features.posts.ui.PostDetail
import com.hassanjamil.sampleandroidpostsapp.features.posts.ui.PostsMain
import com.hassanjamil.sampleandroidpostsapp.navigation.Screen.PostDetail as PostDetailScreen

@Composable
fun NavigationRoot() {
    val backStack = rememberNavBackStack(Screen.Home)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
            rememberSceneSetupNavEntryDecorator()
        ),
        entryProvider = { key ->
            when (key) {
                is Screen.Home -> NavEntry(key) {
                    PostsMain(onPostClick = { post ->
                        backStack.add(PostDetailScreen(post))
                    })
                }
                is PostDetailScreen -> NavEntry(key) {
                    PostDetail(post = key.post)
                }
                else -> error("Unknown NavKey: $key")
            }
        })
}
