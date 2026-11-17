package com.kadico.details.data

import com.kadico.details.domain.SimilarApp


class SimilarAppMapper {
    fun toDomain(dto: SimilarAppDto): SimilarApp = SimilarApp(
        id = dto.id,
        name = dto.name,
        iconUrl = dto.iconUrl,
    )
}
