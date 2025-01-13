package org.hyunjung.day18.datasource

import day18.dto.PhotoResponse

interface PhotoDataSource {
    suspend fun getPhotos(query: String): PhotoResponse
}