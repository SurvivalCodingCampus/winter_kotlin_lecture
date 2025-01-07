package org.example.day15.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.fetchData
import org.example.day15.data.datasource.PhotoDataSource
import org.example.day15.data.model.Photo
import org.example.day15.data.resource.BASE_URL

class PhotoRemoteDataSource : PhotoDataSource {
    override suspend fun getPhotos(albumId: Int): Flow<List<Photo>> = flow {
        emit(fetchData<List<Photo>>("$BASE_URL/photos?albumId=$albumId"))
    }
}