package day15.data_source.photo

import utils.network.ResponseResult
import day15.model.Photo

interface PhotoDataSource {

    suspend fun getPhotos(): ResponseResult<List<Photo>>
}