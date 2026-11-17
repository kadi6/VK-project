package com.kadico.vk_project.app.data

import com.kadico.vk_project.app.domain.AppInfo
import com.kadico.vk_project.app.domain.AppInfoRepository














class AppInfoRepositoryImpl(
    private val api: AppInfoApi,
    private val mapper: AppInfoMapper
): AppInfoRepository {

    override suspend fun getAppInfo(id: String): AppInfo {
        val dto = api.get()
        val domain = mapper.map(dto)

        return domain
    }

}