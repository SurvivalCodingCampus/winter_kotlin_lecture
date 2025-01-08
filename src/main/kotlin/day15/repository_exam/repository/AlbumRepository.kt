package org.example.day15.repository_exam.repository

import org.example.day15.repository_exam.model.Album

interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}