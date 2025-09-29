package com.hassanjamil.sampleandroidpostsapp.presentation.features.postDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hassanjamil.sampleandroidpostsapp.R
import com.hassanjamil.sampleandroidpostsapp.domain.model.Post
import com.hassanjamil.sampleandroidpostsapp.presentation.features.home.PostViewModel
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

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Use a Column so both cards are stacked and spaced consistently.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing) // safe area once at top-level
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Post Detail Card
            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    val title = post.title?.takeIf { it.isNotBlank() }
                        ?: "Post #${post.id}"
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = post.body?.takeIf { it.isNotBlank() } ?: "No description available.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            // Author Card
            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(R.drawable.person),
                        contentDescription = "Author icon"
                    )
                    val userLabel = when {
                        userState?.name?.isNotBlank() == true -> userState?.name
                        userState?.username?.isNotBlank() == true -> userState?.username
                        else -> null
                    }
                    Text(
                        modifier = Modifier.padding(start = 3.dp ),
                        text = userLabel ?: "User details not available",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
