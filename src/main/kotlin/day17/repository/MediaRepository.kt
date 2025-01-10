package day17.repository

import day17.model.MediaItem

interface MediaRepository {
    suspend fun getAll(): List<MediaItem>
}