package com.kadico.vk_project.full.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

data class AppInfo(
    val iconApp: ImageVector,
    val titleApp: String,
    val descriptionApp: String,
    val categoryApp: String
)

val listApps = listOf(
    AppInfo(Icons.Filled.Email, "VK Mail", "Быстрая и безопасная почта", "Инструменты"),
    AppInfo(Icons.Filled.PlayArrow, "VK Video", "Видео и трансляции", "Развлечения"),
    AppInfo(Icons.Filled.ThumbUp, "VK Клипы", "Короткие вертикальные видео", "Социальные"),
    AppInfo(Icons.Filled.LocationOn, "VK Maps", "Навигация по городу", "Карты"),
    AppInfo(Icons.Filled.ShoppingCart, "VK Market", "Покупки внутри экосистемы", "Шопинг"),
    AppInfo(Icons.Filled.DateRange, "VK Calendar", "Планируйте свои дела", "Продуктивность"),
    AppInfo(Icons.Filled.Call, "VK Calls", "Групповые видеозвонки", "Связь"),
    AppInfo(Icons.Filled.Star, "VK Music", "Миллионы треков в кармане", "Музыка"),
    AppInfo(Icons.Filled.Face, "VK Friends", "Найдите новых знакомых", "Социальные"),
    AppInfo(Icons.Filled.Build, "VK Dev", "Инструменты для разработчиков", "Разработка"),
    AppInfo(Icons.AutoMirrored.Filled.List, "VK News", "Актуальные новости мира", "Медиа"),
    AppInfo(Icons.Filled.Lock, "VK Protect", "Защита ваших данных", "Безопасность")
)