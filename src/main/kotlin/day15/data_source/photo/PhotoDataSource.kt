package day15.data_source.photo

import day15.common.ResponseResult
import day15.model.Photo

interface PhotoDataSource {

    suspend fun getPhotos(): ResponseResult<List<Photo>>
}