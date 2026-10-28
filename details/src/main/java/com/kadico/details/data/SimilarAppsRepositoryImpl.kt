package com.kadico.details.data


import com.kadico.details.domain.SimilarApp
import com.kadico.details.domain.SimilarAppsRepository
import javax.inject.Inject

class SimilarAppsRepositoryImpl @Inject constructor(
    private val api: SimilarAppsApi,
    private val mapper: SimilarAppMapper,
) : SimilarAppsRepository {
    override suspend fun getSimilarApps(): List<SimilarApp> =
        api.getSimilarApps().map(mapper::toDomain)
}
