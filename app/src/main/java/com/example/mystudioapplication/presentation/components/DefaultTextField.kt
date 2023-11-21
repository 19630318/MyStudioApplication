package com.example.mystudioapplication.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardOptions: KeyboardOptions,
    color: Color = MaterialTheme.colorScheme.primary,
    hideText: Boolean = false,
    fontSize: TextUnit = 15.sp
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { text ->
            onValueChange(text)
        },
        label = {
            Text(text = label, fontSize = fontSize)
        },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "Correo", tint = color)
        },
        keyboardOptions = keyboardOptions,
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None,
        maxLines = 1,
        singleLine = true
    )
}