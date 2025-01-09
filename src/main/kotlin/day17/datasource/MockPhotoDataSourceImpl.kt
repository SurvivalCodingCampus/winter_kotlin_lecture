package day17.datasource

import day15.common.ResponseResult
import day15.common.safeCall
import day17.dto.PhotoDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl(
    private val jsonData: String
) : PhotoDataSource {
    override suspend fun getPhoto(): ResponseResult<List<PhotoDto>> = withContext(Dispatchers.IO) {
        safeCall {
            val json = Json { ignoreUnknownKeys = true }
            json.decodeFromString<List<PhotoDto>>(jsonData)
        }
    }
}