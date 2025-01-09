package day17.repository

import day17.datasource.MediaItemDataSource
import day17.dto.toMediaItem
import day17.model.MediaItem

class MediaRepositoryImpl(private val source: MediaItemDataSource) : MediaRepository {
    override suspend fun getAll(): List<MediaItem> {
        return source.getItems().map {
            it.toMediaItem()
        }
    }
}