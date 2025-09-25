package com.hassanjamil.sampleandroidpostsapp.posts.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hassanjamil.sampleandroidpostsapp.posts.data.Post

@Composable
fun PostsList(
    modifier: Modifier = Modifier,
    itemModifier: Modifier = Modifier,
    posts: List<Post>
) {
    LazyColumn(modifier = modifier) {
        items(
            items = posts,
            key = { post -> post.id }
        ) { post ->
            PostItem(modifier = itemModifier, post = post)
        }
    }
}
