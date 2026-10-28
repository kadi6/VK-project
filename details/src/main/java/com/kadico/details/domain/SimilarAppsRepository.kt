package com.kadico.details.domain

interface SimilarAppsRepository {
    suspend fun getSimilarApps(): List<SimilarApp>
}
