package com.kadico.vk_project.app.domain









/*
    Use Case - зависит не от конкретной реализации репозитория, а от абстракции репозитория
    т.e в параметре конструктора Use Case указана зависимость (необходимая для его инициализации)
    не от конкретного типа, а от абстрактного интерфейса !!!
*/






interface GetAppInfoUseCase {
    suspend fun get() : AppInfo
}


class GetAppInfoUseCaseImpl(
    private val repository: AppInfoRepository                                                        // В зависимость указываем интерфейс
) : GetAppInfoUseCase {

    override suspend fun get() : AppInfo {
        val appInfo = repository.getAppInfo(id = "")

        if(appInfo.size < 1000) {
            throw IllegalArgumentException()
        } else {
            return appInfo
        }

    }

}