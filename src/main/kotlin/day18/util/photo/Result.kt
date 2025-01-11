package org.example.day18.util.photo

import kotlinx.io.IOException
import org.example.day18.model.photo.Photo


sealed class Result<out D, out E> {
    class Success<out D>(val data: D) : Result<D, Nothing>()
    class Error<out E>(val error: E) : Result<Nothing, E>()

    companion object {
        fun checkPhotoError(result: Result<List<Photo>, PhotoError>): List<Photo> {
            when (result) {
                is Error<PhotoError> ->
                    when (result.error) {
                        PhotoError.NetWorkError -> throw IOException("네트워크 에러")
                        PhotoError.EmptyQuery -> throw IllegalArgumentException("빈 쿼리")
                        is PhotoError.ServerError -> throw Exception("서버 에러 (500)")
                    }

                is Success<List<Photo>> -> return result.data
            }
        }
    }
}