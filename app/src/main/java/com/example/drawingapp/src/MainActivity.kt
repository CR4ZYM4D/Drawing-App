package com.example.drawingapp.src

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.drawingapp.functionality.ImageButton
import com.example.drawingapp.ui.theme.DrawingAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DrawingAppTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding  ->

                    // create composable view from view given in factory
                    AndroidView(factory =  {context ->
                            DrawingView(context).apply {
                                changeBrushSize(12.toFloat())
                            }
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )

                    ImageButton("brush size", onClick = {})
                }
            }
        }
    }
}
