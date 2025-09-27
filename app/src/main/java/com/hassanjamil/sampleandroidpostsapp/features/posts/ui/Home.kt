package com.hassanjamil.sampleandroidpostsapp.features.posts.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.Post
import com.hassanjamil.sampleandroidpostsapp.features.posts.ui.viewModels.PostViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home(
    modifier: Modifier = Modifier,
    onPostClick: (Post) -> Unit
) {
    val postViewModel: PostViewModel = koinViewModel()

    Scaffold(modifier = modifier) { innerPadding ->
        PostsList(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            itemModifier = Modifier.fillMaxWidth(),
            posts = postViewModel.posts,
            onPostClick = onPostClick
        )
    }
}
