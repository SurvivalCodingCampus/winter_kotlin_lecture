package day17.datasource

import day15.common.ResponseResult
import day15.common.safeCall
import day16.util.HttpClientFactory
import day17.dto.MaskResponse
import day17.utils.Const
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class MaskDataSourceImpl : MaskDataSource {
    override suspend fun getStore(): ResponseResult<MaskResponse> = withContext(Dispatchers.IO) {
        safeCall {
            val response = HttpClientFactory.client.get(Const.TEST_URL)
            Json.decodeFromString<MaskResponse>(response.bodyAsText())
        }
    }
}