package com.hassanjamil.sampleandroidpostsapp.presentation.features.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hassanjamil.sampleandroidpostsapp.data.model.Post

@Composable
fun PostsList(
    modifier: Modifier = Modifier,
    itemModifier: Modifier = Modifier,
    posts: List<Post>,
    onPostClick: (Post) -> Unit,
) {
    LazyColumn(modifier = modifier) {
        items(
            items = posts,
            key = { post -> post.id }
        ) { post ->
            PostListItem(
                modifier = itemModifier,
                post = post,
                onPostClick = onPostClick
            )
        }
    }
}
