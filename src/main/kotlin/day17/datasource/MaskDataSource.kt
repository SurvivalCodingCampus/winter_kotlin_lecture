package day17.datasource

import utils.network.ResponseResult
import day17.dto.MaskResponse

interface MaskDataSource {
    suspend fun getStore(): ResponseResult<MaskResponse>
}