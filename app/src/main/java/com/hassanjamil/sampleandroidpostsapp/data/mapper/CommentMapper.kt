package com.hassanjamil.sampleandroidpostsapp.data.mapper

import com.hassanjamil.sampleandroidpostsapp.data.model.Comment as CommentData
import com.hassanjamil.sampleandroidpostsapp.domain.model.Comment

fun CommentData.toDomain(): Comment = Comment(
    id = id,
    body = body,
    userId = userId,
    postId = postId,
)

fun Comment.toData(): CommentData = CommentData(
    id = id,
    body = body,
    userId = userId,
    postId = postId,
)
