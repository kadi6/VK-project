package com.kadico.vk_project.app.di

import com.kadico.vk_project.app.data.AppInfoApi
import com.kadico.vk_project.app.data.AppInfoMapper
import com.kadico.vk_project.app.data.AppInfoRepositoryImpl
import com.kadico.vk_project.app.domain.AppInfoRepository
import com.kadico.vk_project.app.domain.GetAppInfoUseCaseImpl








    /*
        Root composition    ---
    */







class AppContainer(

) {
    private val api = AppInfoApi()
    private val mapper = AppInfoMapper()
    private val repository: AppInfoRepository = AppInfoRepositoryImpl(api = api, mapper = mapper)


    public val getAppInfoUseCase = GetAppInfoUseCaseImpl(repository)

}