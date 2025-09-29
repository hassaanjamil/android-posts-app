package com.hassanjamil.sampleandroidpostsapp.data.mapper

import com.hassanjamil.sampleandroidpostsapp.data.model.Post as PostData
import com.hassanjamil.sampleandroidpostsapp.domain.model.Post

fun PostData.toDomain(): Post = Post(
    id = id,
    title = title,
    body = body,
    userId = userId,
    isFavorite = isFavorite,
)

fun Post.toData(): PostData = PostData(
    id = id,
    title = title.orEmpty(),
    body = body.orEmpty(),
    userId = userId ?: 0,
    isFavorite = isFavorite,
)
