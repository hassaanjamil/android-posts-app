package com.hassanjamil.sampleandroidpostsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hassanjamil.sampleandroidpostsapp.presentation.navigation.graph.RootGraph
import com.hassanjamil.sampleandroidpostsapp.presentation.theme.AndroidPostsAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPostsAppTheme(dynamicColor = false) {
                RootGraph()
            }
        }
    }
}
