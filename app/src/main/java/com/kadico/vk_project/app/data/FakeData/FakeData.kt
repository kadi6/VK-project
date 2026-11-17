package com.kadico.vk_project.app.data.FakeData

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
import com.kadico.vk_project.app.domain.AppInfo






val listApps = listOf(
    AppInfo(Icons.Filled.Email, "VK Mail", "Быстрая и безопасная почта", "Инструменты", 45.5f, 5),
    AppInfo(Icons.Filled.PlayArrow, "VK Video", "Видео и трансляции", "Развлечения", 125.8f, 4),
    AppInfo(Icons.Filled.ThumbUp, "VK Клипы", "Короткие вертикальные видео", "Социальные", 87.3f, 4),
    AppInfo(Icons.Filled.LocationOn, "VK Maps", "Навигация по городу", "Карты", 98.6f, 5),
    AppInfo(Icons.Filled.ShoppingCart, "VK Market", "Покупки внутри экосистемы", "Шопинг", 72.4f, 3),
    AppInfo(Icons.Filled.DateRange, "VK Calendar", "Планируйте свои дела", "Продуктивность", 32.1f, 4),
    AppInfo(Icons.Filled.Call, "VK Calls", "Групповые видеозвонки", "Связь", 64.7f, 5),
    AppInfo(Icons.Filled.Star, "VK Music", "Миллионы треков в кармане", "Музыка", 110.2f, 5),
    AppInfo(Icons.Filled.Face, "VK Friends", "Найдите новых знакомых", "Социальные", 56.9f, 3),
    AppInfo(Icons.Filled.Build, "VK Dev", "Инструменты для разработчиков", "Разработка", 28.5f, 4),
    AppInfo(Icons.AutoMirrored.Filled.List, "VK News", "Актуальные новости мира", "Медиа", 48.3f, 4),
    AppInfo(Icons.Filled.Lock, "VK Protect", "Защита ваших данных", "Безопасность", 35.6f, 5)
)