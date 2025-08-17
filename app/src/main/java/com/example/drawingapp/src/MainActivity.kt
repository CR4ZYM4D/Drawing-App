package com.example.drawingapp.src

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.drawingapp.functionality.ChangeBrushSize
import com.example.drawingapp.ui.theme.DrawingAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DrawingAppTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->

                    // initialize nullable drawing view for buttons
                    var drawingView by remember { mutableStateOf<DrawingView?>(null) }

                    // create composable view from view given in factory
                    AndroidView(
                        factory = { context ->

                            // initialize drawing view
                            DrawingView(context).apply {
                                changeBrushSize(12.toFloat())
                            }
                                .also { it -> drawingView = it }

                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )


                    drawingView?.let {
                        Row(

                            verticalAlignment = Alignment.Bottom) {
                            ChangeBrushSize(
                                it,
                                modifier = Modifier
                                    .padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}