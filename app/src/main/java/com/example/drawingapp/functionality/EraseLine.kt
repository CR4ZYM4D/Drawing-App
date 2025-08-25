package com.example.drawingapp.functionality

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.drawingapp.src.DrawingView

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun EraseLine(drawingView: DrawingView, modifier:Modifier = Modifier){

    val drawingView by remember { mutableStateOf<DrawingView>(drawingView) }

    var isErasing by remember {mutableStateOf(false)}

    val eraseButton = ImageButton(
        "erase",
        onClick = {isErasing = !isErasing},
        modifier = Modifier,
        onLongClick = {} ,
    )

    if(isErasing){
        drawingView.changeBrushColor("white")
    }
    else{
        drawingView.changeBrushColor("Black")
    }

}