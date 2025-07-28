package com.example.drawingapp.functionality

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.drawingapp.R
import com.example.drawingapp.ui.theme.DrawingAppTheme

@Composable
fun ImageButton(buttonType: String, onClick: ()-> Unit, modifier: Modifier = Modifier){

    when (buttonType) {

        "brush size" -> Image(painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Brush Size",
            modifier = modifier
           .size(40.dp)
           .clickable(onClick = onClick),
        )

    }

}

@Composable
@PreviewLightDark
private fun ImageButtonPreview(){

    DrawingAppTheme {

        ImageButton("brush size", onClick = {})

    }

}