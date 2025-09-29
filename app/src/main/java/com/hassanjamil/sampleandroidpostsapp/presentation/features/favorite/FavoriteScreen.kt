package com.hassanjamil.sampleandroidpostsapp.presentation.features.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hassanjamil.sampleandroidpostsapp.domain.model.Post
import com.hassanjamil.sampleandroidpostsapp.presentation.features.home.PostViewModel
import com.hassanjamil.sampleandroidpostsapp.presentation.features.home.PostsList
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier, onPostClick: ((Post) -> Unit)?) {
    val postViewModel: PostViewModel = koinViewModel()
    val favoriteViewModel: FavoriteViewModel = koinViewModel()

    if (favoriteViewModel.favPosts.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing),
            contentAlignment = Alignment.Center
        ) {
            Text("No Favorites")
        }
        return
    }

    PostsList(
        modifier = modifier,
        posts = favoriteViewModel.favPosts,
        onPostClick = onPostClick,
        onFavoritePostClick = { selectedPost ->
            val nextFavoriteState = !selectedPost.isFavorite
            postViewModel.updateFavoriteState(selectedPost.id, nextFavoriteState)
            favoriteViewModel.toggleFavoritePost(selectedPost.copy(isFavorite = nextFavoriteState))
        }
    )
}
