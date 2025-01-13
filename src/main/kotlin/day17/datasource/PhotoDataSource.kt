package day17.datasource

import utils.network.ResponseResult
import day17.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhoto(): ResponseResult<List<PhotoDto>>
}