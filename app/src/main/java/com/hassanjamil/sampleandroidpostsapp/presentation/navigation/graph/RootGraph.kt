package com.hassanjamil.sampleandroidpostsapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.hassanjamil.sampleandroidpostsapp.presentation.features.auth.AuthScreen
import com.hassanjamil.sampleandroidpostsapp.presentation.features.profile.ProfileScreen
import com.hassanjamil.sampleandroidpostsapp.presentation.navigation.model.RootScreen
import com.hassanjamil.sampleandroidpostsapp.presentation.features.postDetail.PostDetail as PostDetailScene

@Composable
fun RootGraph() {
    val backStack = rememberNavBackStack<RootScreen>(RootScreen.Auth)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<RootScreen.Auth> {
                AuthScreen(onLoginClick = {
                    // Removing auth screen from backstack
                    // before adding nested graph
                    backStack.clear()
                    backStack.add(RootScreen.NestedBottomBarGraph)
                })
            }
            entry<RootScreen.Profile> {
                ProfileScreen()
            }
            entry<RootScreen.PostDetail> { navEntry ->
                PostDetailScene(post = navEntry.post)
            }
            entry<RootScreen.NestedBottomBarGraph> {
                NestedBottomBarGraph(
                    navigateToProfile = {
                        backStack.add(RootScreen.Profile)
                    },
                    onPostClick = { post ->
                        backStack.add(RootScreen.PostDetail(post))
                    }
                )
            }
        }
    )
}
