package com.hassanjamil.sampleandroidpostsapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.hassanjamil.sampleandroidpostsapp.presentation.features.auth.AuthScreen
import com.hassanjamil.sampleandroidpostsapp.presentation.features.profile.ProfileScreen
import com.hassanjamil.sampleandroidpostsapp.presentation.navigation.model.Screen
import com.hassanjamil.sampleandroidpostsapp.presentation.features.postDetail.PostDetail as PostDetailScene

@Composable
fun RootGraph() {
    val backStack = rememberNavBackStack<Screen>(Screen.Auth)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Screen.Auth> {
                AuthScreen(onLoginClick = {
                    backStack.add(Screen.NestedGraph)
                })
            }
            entry<Screen.Profile> {
                ProfileScreen()
            }
            entry<Screen.PostDetail> { navEntry ->
                PostDetailScene(post = navEntry.post)
            }
            entry<Screen.NestedGraph> {
                NestedGraph(
                    navigateToProfile = {
                        backStack.add(Screen.Profile)
                    },
                    onPostClick = { post ->
                        backStack.add(Screen.PostDetail(post))
                    }
                )
            }
        }
    )
}
