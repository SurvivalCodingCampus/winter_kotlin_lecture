package day17.datasource

import day15.common.ResponseResult
import day17.dto.MaskResponse

interface MaskDataSource {
    suspend fun getStore(): ResponseResult<MaskResponse>
}