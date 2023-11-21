package com.example.mystudioapplication.presentation.screens.client.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.mystudioapplication.domain.model.MenuItemNetwork

@Composable
fun ProductsItem(product: MenuItemNetwork) {

    Card(
        modifier = Modifier.fillMaxWidth().height(160.dp).padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(1.dp),
        shape = CardDefaults.shape,
        border = BorderStroke(10.dp, MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            SubcomposeAsyncImage(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = product.imageUrl,
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                Modifier.weight(1f)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = product.title, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = product.description, style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = product.price.toString(), style = MaterialTheme.typography.bodyMedium)
            }
        }

    }
}