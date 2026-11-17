package com.kadico.details.domain

import kotlinx.coroutines.flow.Flow

class GetAppDetailsUseCase(
    private val appDetailsRepository: AppDetailsRepository,
) {
    suspend operator fun invoke(id: String): Flow<AppDetails> =
        appDetailsRepository.getAppDetails(id)
}