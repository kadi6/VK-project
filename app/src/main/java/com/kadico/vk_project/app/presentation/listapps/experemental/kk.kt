package com.kadico.vk_project.app.presentation.listapps.experemental


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage






@Composable
fun AppListImage(modifier: Modifier,
                 model: String,
                 contentDescription: String?
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = model,
        contentDescription = contentDescription,
        loading = {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.size(32.dp))
            }
        },
        error = {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Default.Close,
                    contentDescription = null
                )
            }
        }
    )
}