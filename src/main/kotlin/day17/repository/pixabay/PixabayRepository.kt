package org.example.day17.repository.pixabay

import RResult
import day17.PhotoError
import day17.PixabayPhoto


interface PixabayRepository {
    suspend fun getPhotos(query: String): RResult<List<PixabayPhoto>, PhotoError>
}


