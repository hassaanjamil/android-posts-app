package com.hassanjamil.sampleandroidpostsapp.presentation.features.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hassanjamil.sampleandroidpostsapp.data.model.Post
import com.hassanjamil.sampleandroidpostsapp.presentation.features.favorite.FavoriteViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onPostClick: (Post) -> Unit
) {
    val postViewModel: PostViewModel = koinViewModel()
    val favoriteViewModel: FavoriteViewModel = koinViewModel()

    PostsList(
        modifier = Modifier
            .fillMaxSize(),
        itemModifier = Modifier.fillMaxWidth(),
        posts = postViewModel.posts,
        onPostClick = onPostClick,
        onFavoritePostClick = {
            favoriteViewModel.toggleFavoritePost(it)
        }
    )
}
