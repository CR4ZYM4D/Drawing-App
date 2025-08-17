package com.example.drawingapp.functionality

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.drawingapp.src.DrawingView
import com.example.drawingapp.ui.theme.DrawingAppTheme

@Composable
fun ChangeBrushSize(drawingView: DrawingView, modifier: Modifier){

    val drawingView by remember { mutableStateOf<DrawingView>(drawingView) }

    var sliderPosition by remember{ mutableIntStateOf(drawingView.getBrushSize()) }

    var sliderIsVisible by remember {mutableStateOf(false)}
    
    val sizeButton = ImageButton(
        buttonType = "brush size",
        onClick = {
            sliderIsVisible = !sliderIsVisible
        },
        modifier = modifier
    )
    
    if (sliderIsVisible)
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Slider(
                value = sliderPosition.toFloat(),
                onValueChange = {
                    drawingView.changeBrushSize(it)
                    sliderPosition = it.toInt()
                },
                valueRange = 1.0f..50.0f,
                enabled = true,
                steps = 25,
                onValueChangeFinished = {sliderIsVisible = !sliderIsVisible}
            )
        }
    }
}

@PreviewLightDark
@Composable
fun PreviewChangeBrushSize(){

    DrawingAppTheme {

        AndroidView(factory = {it->
            DrawingView(it)
        })


    }

}