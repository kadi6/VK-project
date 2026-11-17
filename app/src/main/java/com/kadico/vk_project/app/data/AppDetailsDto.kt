package com.kadico.vk_project.app.data

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable












data class AppInfoDto(
    val iconApp: ImageVector,
    val nameApp: String,
    val aboutApp: String,
    val categoryApp: String,
    val size: Float,
    val appRating: Int,
)