package com.hassanjamil.sampleandroidpostsapp.presentation.navigation.model

import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavKey
import com.hassanjamil.sampleandroidpostsapp.R
import kotlinx.serialization.Serializable

val bottomBarItems = listOf<BottomBarScreen>(
    BottomBarScreen.Home,
    BottomBarScreen.Favorite,
    BottomBarScreen.Settings,
)

@Suppress("unused")
@Serializable
sealed class BottomBarScreen(
    val icon: Int,
    val title: String,
): NavKey {
    @Serializable
    data object Home : BottomBarScreen(
        icon = R.drawable.home,
        title = "Home"
    )

    @Serializable
    data object Favorite : BottomBarScreen(
        icon = R.drawable.favorite,
        title = "Favorite"
    )

    @Serializable
    data object Settings : BottomBarScreen(
        icon = R.drawable.settings,
        title = "Settings"
    )
}

val BottomBarScreenSaver = Saver<BottomBarScreen, String>(
    save = { it::class.simpleName ?: "Unknown" },
    restore = {
        when (it) {
            BottomBarScreen.Home::class.simpleName -> BottomBarScreen.Home
            BottomBarScreen.Favorite::class.simpleName -> BottomBarScreen.Favorite
            BottomBarScreen.Settings::class.simpleName -> BottomBarScreen.Settings
            else -> BottomBarScreen.Home
        }
    }
)
