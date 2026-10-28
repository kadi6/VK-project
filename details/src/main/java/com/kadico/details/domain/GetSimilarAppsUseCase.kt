package com.kadico.details.domain



class GetSimilarAppsUseCase(
    private val repository: SimilarAppsRepository,
) {
    suspend operator fun invoke(): List<SimilarApp> = repository.getSimilarApps()
}
