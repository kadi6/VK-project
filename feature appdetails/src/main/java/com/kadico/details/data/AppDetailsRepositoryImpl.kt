package com.kadico.details.data


import com.kadico.details.data.local.AppApi
import com.kadico.details.data.local.AppDetailsDao
import com.kadico.details.data.local.AppDetailsEntityMapper
import com.kadico.details.data.local.AppDetailsMapper
import com.kadico.details.domain.AppDetails
import com.kadico.details.domain.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val dao: AppDetailsDao,
    private val mapper: AppDetailsMapper,
    private val entityMapper: AppDetailsEntityMapper,
) : AppDetailsRepository {

    override suspend fun getAppDetails(id: String): Flow<AppDetails> {
        return dao.getAppDetails(id).map { entity ->
            if (entity != null) {
                entityMapper.toDomain(entity)
            } else {
                val dto = appApi.getAppDetails(id)
                val domain = mapper.toDomain(dto)
                val entity = entityMapper.toEntity(domain)
                withContext(Dispatchers.IO) {
                    dao.insertAppDetails(entity)
                }
                domain
            }
        }
    }
}