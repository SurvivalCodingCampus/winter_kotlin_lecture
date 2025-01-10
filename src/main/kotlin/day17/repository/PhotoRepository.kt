package day17.repository

import day17.data_source.MockPhotoDataSourceImpl
import day17.data_source.PhotoDataSource
import day17.mapper.PhotoMapper
import day17.model.Photo
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

interface PhotoRepository {
    suspend fun getUsableStoreData1(): List<Photo>
    suspend fun getUsableStoreData2(): List<Photo>
}

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource) : PhotoRepository {
    val photoMapper = PhotoMapper()
    override suspend fun getUsableStoreData1(): List<Photo> {
        return dataSource.getPhotoList1().map {
            photoMapper.photoDTOtoPhoto(it)
        }
    }

    override suspend fun getUsableStoreData2(): List<Photo> {
        return dataSource.getPhotoList2().map {
            photoMapper.photoDTOtoPhoto(it)
        }
    }
}

fun main() = runBlocking {
    val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

    val photoList = photoRepositoryImpl.getUsableStoreData1()
}