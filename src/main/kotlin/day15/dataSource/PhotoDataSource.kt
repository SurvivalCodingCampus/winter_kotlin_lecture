package day15.dataSource

import day15.model.Photo

interface PhotoDataSource {
    suspend fun photoData(): List<Photo>
}