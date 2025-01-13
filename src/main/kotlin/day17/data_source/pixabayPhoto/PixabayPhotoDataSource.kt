package org.example.day17.data_source.pixabayPhoto

import RResult
import day17.PhotoError
import day17.PixabayPhoto


interface PixabayPhotoDataSource {
    suspend fun getPhotos(query: String): RResult<List<PixabayPhoto>, PhotoError>
}
