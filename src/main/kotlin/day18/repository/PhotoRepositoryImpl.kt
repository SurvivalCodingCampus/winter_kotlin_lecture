package day18.repository

import ResultPhoto
import day18.dataSource.PhotoDataSource
import day18.mapper.toPhoto
import day18.model.Photo
import day18.util.PhotoError
import kotlinx.io.IOException

class PhotoRepositoryImpl(private val photoDataSource: PhotoDataSource) : PhotoRepository {
    override suspend fun getPhotos(query: String): ResultPhoto<List<Photo>> {
        if (query.isBlank()) {  // isEmpty는 빈 스트링을 확인하고(공백 체크 못함), isBlank는 공백도 확인해 준다
            return ResultPhoto.Error(PhotoError.EmptyQuery)
        }
        try {
            val photos = photoDataSource.getPhoto(query).map { it.toPhoto() }   // map이 { it.toPhoto() } 반환값을 list로 타입 변환 시켜 준다.
            return ResultPhoto.Success(photos)                                              // it은 PhotoDto 타입. toPhoto()는 매퍼고 Photo 타입. 즉 결과적으로 List<Photo>
        } catch (e: IOException) {
            return ResultPhoto.Error(PhotoError.NetworkError)
        } catch (e: Exception) {
            throw e
        }
    }
}