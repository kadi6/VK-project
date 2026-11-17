package com.kadico.vk_project.app.presentation.listapps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kadico.vk_project.app.domain.GetAppInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException












class ListAppsViewModel(
    private val getAppInfoUseCase: GetAppInfoUseCase
) : ViewModel() {


    private val _uiState =
        MutableStateFlow<ListAppsUiState>(
            ListAppsUiState.Loading
        )


    val uiState = _uiState.asStateFlow()


    init {
        loadAppInfo()
    }


    private fun loadAppInfo() {
        viewModelScope.launch {
            try {
                val result = getAppInfoUseCase.get()

                _uiState.value =
                    ListAppsUiState.Success(result)

            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value =
                    ListAppsUiState.Error
            }
        }
    }
}