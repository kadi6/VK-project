package com.kadico.details.domain

import com.kadico.details.domain.AppDetails
import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): Flow<AppDetails>
}