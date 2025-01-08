package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.data_source.AlbumDatasource
import org.example.day15.repository_exam.model.Album

class AlbumRepositoryImpl(private val datasource: AlbumDatasource) : AlbumRepository {
    override suspend fun getAlbums(limit: Int?): List<Album> {
        return if (limit == null) {
            datasource.getAllAlbums()
        } else {
            datasource.getAllAlbums().subList(0, limit)
        }
    }
}