package com.hassanjamil.sampleandroidpostsapp.presentation.navigation.graph


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.hassanjamil.sampleandroidpostsapp.R
import com.hassanjamil.sampleandroidpostsapp.domain.model.Post
import com.hassanjamil.sampleandroidpostsapp.presentation.features.favorite.FavoriteScreen
import com.hassanjamil.sampleandroidpostsapp.presentation.features.home.HomeScreen
import com.hassanjamil.sampleandroidpostsapp.presentation.features.settings.SettingsScreen
import com.hassanjamil.sampleandroidpostsapp.presentation.navigation.model.BottomBarScreen
import com.hassanjamil.sampleandroidpostsapp.presentation.navigation.model.BottomBarScreenSaver
import com.hassanjamil.sampleandroidpostsapp.presentation.navigation.model.bottomBarItems

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NestedBottomBarGraph(navigateToProfile: () -> Unit, onPostClick: (post: Post) -> Unit) {
    val backStack = rememberNavBackStack<BottomBarScreen>(BottomBarScreen.Home)

    var currentBottomBarScreen: BottomBarScreen by rememberSaveable(
        inputs = arrayOf(backStack),
        stateSaver = BottomBarScreenSaver
    ) { mutableStateOf(BottomBarScreen.Home) }

//    val stateHolder = rememberSaveableStateHolder()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Posts App") },
                actions = {
                    IconButton(onClick = navigateToProfile) {
                        Icon(
                            painter = painterResource(R.drawable.person),
                            contentDescription = "Profile icon"
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                bottomBarItems.forEach { destination ->
                    NavigationBarItem(
                        selected = currentBottomBarScreen == destination,
                        icon = {
                            Icon(
                                painter = painterResource(destination.icon),
                                contentDescription = "$destination icon"
                            )
                        },
                        onClick = {
                            if (backStack.lastOrNull() != destination) {
                                if (backStack.lastOrNull() in bottomBarItems) {
                                    backStack.removeAt(backStack.lastIndex)
                                }
                                backStack.add(destination)
                                currentBottomBarScreen = destination
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .consumeWindowInsets(innerPadding)
            ) {
                NavDisplay(
                    backStack = backStack,
                    onBack = { backStack.removeLastOrNull() },
                    entryDecorators = listOf(
                        rememberSavedStateNavEntryDecorator(),
                        rememberViewModelStoreNavEntryDecorator()
                    ),
                    entryProvider = entryProvider {
                        entry<BottomBarScreen.Home> {
                            HomeScreen(onPostClick = onPostClick)
                        }
                        entry<BottomBarScreen.Favorite> {
                            FavoriteScreen(onPostClick = onPostClick)
                        }
                        entry<BottomBarScreen.Settings> {
                            SettingsScreen()
                        }
                    }
                )
            }
        }
    }
}
