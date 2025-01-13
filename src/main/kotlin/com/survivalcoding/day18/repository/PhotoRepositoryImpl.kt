package com.survivalcoding.com.survivalcoding.day18.repository

import com.survivalcoding.com.survivalcoding.day18.data_source.PhotoDataSource
import com.survivalcoding.com.survivalcoding.day18.mapper.toPhoto
import com.survivalcoding.com.survivalcoding.day18.model.Photo
import com.survivalcoding.com.survivalcoding.day18.util.Result
import kotlinx.io.IOException

class PhotoRepositoryImpl(
    private val dataSource: PhotoDataSource,
) : PhotoRepository {

    override suspend fun getPhotos(query: String): Result<List<Photo>> {
        if (query.isBlank()) {
            return Result.Error("빈 검색어")
        }

        try {
            val results = dataSource.getPhotos(query)
            return Result.Success(results.map { it.toPhoto() })
        } catch (e: IOException) {
            return Result.Error("네트워크 에러입니다")
        } catch (e: Exception) {
            return Result.Error("서버 에러입니다")
        }
    }
}
