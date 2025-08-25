package com.example.drawingapp.functionality

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.drawingapp.R
import com.example.drawingapp.ui.theme.DrawingAppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageButton(
    buttonType: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    onLongClick: (() -> Unit) = {}
){

    when (buttonType) {

        "brush size" -> Image(painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Brush Size",
            modifier = modifier
           .size(40.dp)
           .combinedClickable(onClick = onClick,
               onLongClick = onLongClick
           )
        )

        "brush color" -> Image(painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Brush Size",
            modifier = modifier
           .size(40.dp)
           .combinedClickable(onClick = onClick,
               onLongClick = onLongClick
           )
        )

        "undo" -> Image(painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Brush Size",
            modifier = modifier
           .size(40.dp)
           .combinedClickable(onClick = onClick,
               onLongClick = onLongClick
           )
        )

        "save" -> Image(painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Brush Size",
            modifier = modifier
           .size(40.dp)
           .combinedClickable(onClick = onClick,
               onLongClick = onLongClick
           )
        )

        "erase" -> Image(painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Brush Size",
            modifier = modifier
           .size(40.dp)
           .combinedClickable(onClick = onClick,
               onLongClick = {}
           )
        )

        "palette" -> Image(painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Brush Size",
            modifier = modifier
           .size(40.dp)
           .combinedClickable(onClick = onClick,
               onLongClick = onLongClick
           )
        )

        "load image" -> Image(painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Brush Size",
            modifier = modifier
           .size(40.dp)
           .combinedClickable(onClick = onClick,
               onLongClick = onLongClick
           )
        )

    }

}

@Composable
@PreviewLightDark
private fun ImageButtonPreview(){

    DrawingAppTheme {

        ImageButton(
            "brush size", onClick = {},

            modifier = Modifier
        )

    }

}