package com.kadico.vk_project.app.domain

import androidx.compose.ui.graphics.vector.ImageVector






    /*
        Domain model - модель предметной области нашего приложения
    */





data class AppInfo(
    val iconApp: ImageVector,
    val titleApp: String,
    val descriptionApp: String,
    val categoryApp: String,
    val size: Float,
    val appRating: Int
)