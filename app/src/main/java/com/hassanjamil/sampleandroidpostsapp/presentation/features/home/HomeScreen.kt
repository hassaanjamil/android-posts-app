package com.hassanjamil.sampleandroidpostsapp.presentation.features.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hassanjamil.sampleandroidpostsapp.data.model.Post
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onPostClick: (Post) -> Unit
) {
    val postViewModel: PostViewModel = koinViewModel()
    PostsList(
        modifier = Modifier
            .fillMaxSize(),
        itemModifier = Modifier.fillMaxWidth(),
        posts = postViewModel.posts,
        onPostClick = onPostClick
    )
}
