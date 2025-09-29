package com.hassanjamil.sampleandroidpostsapp.data.mapper

import com.hassanjamil.sampleandroidpostsapp.data.model.User as UserData
import com.hassanjamil.sampleandroidpostsapp.domain.model.User

fun UserData.toDomain(): User = User(
    id = id ?: 0,
    username = username,
    name = name,
)

//fun User.toData(): UserData = UserData(
//    id = id,
//    username = username,
//    name = name,
//)
