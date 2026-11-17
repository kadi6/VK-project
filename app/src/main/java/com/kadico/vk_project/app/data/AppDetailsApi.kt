package com.kadico.vk_project.app.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email









/*
    Data Source - Источник данных
*/







class AppInfoApi {
    suspend fun get(): AppInfoDto {

        return AppInfoDto(
            iconApp = Icons.Filled.Email,
            nameApp = "Картошка",
            aboutApp = "Это современное приложение для работы с API ВКонтакте, созданное с использованием Jetpack Compose и чистой архитектуры.",
            categoryApp = "Социальные сети",
            size = 4.4f,
            appRating = 4
        )

    }
}