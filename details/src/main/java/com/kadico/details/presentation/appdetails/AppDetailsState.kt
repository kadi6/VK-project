package com.kadico.details.presentation.appdetails


import androidx.compose.runtime.Immutable
import com.kadico.details.domain.AppDetails
import com.kadico.details.domain.SimilarApp


@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val similarApps: List<SimilarApp>,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}