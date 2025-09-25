package com.hassanjamil.sampleandroidpostsapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hassanjamil.sampleandroidpostsapp.posts.ui.PostsList
import com.hassanjamil.sampleandroidpostsapp.posts.ui.PostsViewModel
import com.hassanjamil.sampleandroidpostsapp.ui.theme.SampleAndroidPostsAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAndroidPostsAppTheme (dynamicColor = false) {
                val postsViewModel = PostsViewModel()
                val posts = postsViewModel.posts

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Greeting(
                            name = "Android",
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 24.dp)
                        )
                        Button(
                            onClick = { onButtonClick() }
                        ) {
                            Text(text = "Click Me")
                        }

                        PostsList(
                            modifier = Modifier
                                .fillMaxSize(),
                            itemModifier = Modifier.fillMaxWidth(),
                            posts = posts
                        )
//                        Toast.makeText(LocalContext.current, posts.size, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }


    fun onButtonClick() {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
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
