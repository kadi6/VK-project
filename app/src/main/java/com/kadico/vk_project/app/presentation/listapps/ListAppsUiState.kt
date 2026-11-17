package com.kadico.vk_project.app.presentation.listapps

import com.kadico.vk_project.app.domain.AppInfo











    /*
        Модель состояний экрана ListApps
    */







sealed interface ListAppsUiState {

    data object Loading : ListAppsUiState

    data class Success(
        val appInfo: AppInfo
    ) : ListAppsUiState

    data object Error : ListAppsUiState
}