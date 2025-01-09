package day17.datasource

import day15.common.ResponseResult
import day17.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhoto(): ResponseResult<List<PhotoDto>>
}