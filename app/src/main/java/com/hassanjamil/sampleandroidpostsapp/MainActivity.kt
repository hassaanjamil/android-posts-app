package com.hassanjamil.sampleandroidpostsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hassanjamil.sampleandroidpostsapp.posts.ui.PostViewModel
import com.hassanjamil.sampleandroidpostsapp.posts.ui.PostsList
import com.hassanjamil.sampleandroidpostsapp.ui.theme.SampleAndroidPostsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val postsViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAndroidPostsAppTheme(dynamicColor = false) {
                val posts = postsViewModel.posts
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PostsList(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        itemModifier = Modifier.fillMaxWidth(),
                        posts = posts
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleAndroidPostsAppTheme {
        Greeting("Android")
    }
}
