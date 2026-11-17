package com.kadico.vk_project.app.data

import com.kadico.vk_project.app.domain.AppInfo












class AppInfoMapper {
    fun map(dto: AppInfoDto) : AppInfo {
        return AppInfo(
            iconApp = dto.iconApp,
            titleApp = dto.nameApp,
            descriptionApp = dto.aboutApp,
            categoryApp = dto.categoryApp,
            size = dto.size,
            appRating = dto.appRating
        )
    }
}