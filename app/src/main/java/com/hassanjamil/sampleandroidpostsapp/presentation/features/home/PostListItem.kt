package com.hassanjamil.sampleandroidpostsapp.presentation.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hassanjamil.sampleandroidpostsapp.R
import com.hassanjamil.sampleandroidpostsapp.data.model.Post


@Composable
fun PostListItem(
    modifier: Modifier = Modifier,
    post: Post,
    onPostClick: ((Post) -> Unit)? = null,
    onFavoritePostClick: ((Post) -> Unit)? = null,
) {
    ElevatedCard(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onPostClick?.invoke(post) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val title = post.title.takeIf { it.isNotBlank() }
                ?: post.id.let { "Post #$it" }
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = post.body.takeIf { it.isNotBlank() } ?: "No description available.",
                style = MaterialTheme.typography.bodyMedium
            )
            Icon(
                // Use a fresh Modifier (not the incoming 'modifier') and make touch target large enough
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable { onFavoritePostClick?.invoke(post) },
                painter =  painterResource(if(post.isFavorite) R.drawable.favorite_filled else R.drawable.favorite),
                contentDescription = "Favorite icon",
            )
        }
    }
}
