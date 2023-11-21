package com.example.mystudioapplication.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colorScheme.primary,
    icon: ImageVector = Icons.Default.ArrowForward,
    enable: Boolean
){
    Button(modifier = modifier,
        onClick = { onClick() },
        enabled = enable,
        colors = ButtonDefaults.buttonColors(containerColor = color)) {
        Icon(imageVector = icon, contentDescription = "")
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}