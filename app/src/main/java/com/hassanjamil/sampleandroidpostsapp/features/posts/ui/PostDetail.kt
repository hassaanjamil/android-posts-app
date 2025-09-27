package com.hassanjamil.sampleandroidpostsapp.features.posts.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hassanjamil.sampleandroidpostsapp.features.posts.data.model.Post
import com.hassanjamil.sampleandroidpostsapp.features.posts.ui.viewModels.PostViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PostDetail(
    modifier: Modifier = Modifier,
    post: Post,
    postViewModel: PostViewModel = koinViewModel()
) {
    val userState by postViewModel.user.collectAsState()

    LaunchedEffect(post.userId) {
        post.userId?.let { postViewModel.fetchUserById(it) }
    }

    ElevatedCard(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val title = post.title?.takeIf { it.isNotBlank() }
                ?: post.id?.let { "Post #$it" }
                ?: "Post"
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = post.body?.takeIf { it.isNotBlank() } ?: "No description available.",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(12.dp))
            val userLabel = when {
                userState?.name?.isNotBlank() == true -> userState?.name
                userState?.username?.isNotBlank() == true -> userState?.username
                else -> null
            }
            Text(
                text = userLabel ?: "User details not available",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
