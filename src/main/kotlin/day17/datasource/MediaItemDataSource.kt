package day17.datasource

import day17.dto.MediaDto

interface MediaItemDataSource {
    suspend fun getItems(): List<MediaDto>
}
