package org.example.day17.repository.pixabay

import RResult
import day17.PhotoError
import day17.PixabayPhoto
import org.example.day17.data_source.pixabayPhoto.PixabayPhotoDataSource


class PixabayRepositoryImpl(
    private val dataSource: PixabayPhotoDataSource
) : PixabayRepository {
    override suspend fun getPhotos(query: String): RResult<List<PixabayPhoto>, PhotoError> {
        return dataSource.getPhotos(query = query)
    }

}