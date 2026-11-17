package com.kadico.vk_project.app.domain







    /*
        Контракт операций, доступных над domain model в use cases
    */





interface AppInfoRepository {
    suspend fun getAppInfo(id: String): AppInfo
}