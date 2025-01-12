package day18.repository

import day18.data_source.PhotoDataSource
import day18.model.Photo
import day18.mapper.toPhoto
import day18.util.PhotoError
import day18.util.Result
import io.ktor.client.plugins.*
import java.io.IOException
import java.lang.IllegalArgumentException

interface PhotoRepository {
    suspend fun getPhotos(query: String): Result<List<Photo>>
}

class PhotoRepositoryImpl(private val dataSource: PhotoDataSource): PhotoRepository {
    override suspend fun getPhotos(query: String): Result<List<Photo>> {

        // Result로 Exception을 매핑해주는 코드
        return try {
            Result.Success(dataSource.getPhotos(query).map {
                it.toPhoto()
            })
        } catch(e: IOException) {               // 네트워크 에러(IOException)
            Result.Error(PhotoError.NetworkError)
        } catch (e: IllegalArgumentException) { // 빈 검색어 체크
            Result.Error(PhotoError.EmptyQuery)
        } catch(e: ServerResponseException) {   // 서버 에러
            Result.Error(PhotoError.ServerError("server error"))
        }

    }
}