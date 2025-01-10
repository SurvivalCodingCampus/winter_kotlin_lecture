package day18.utils

import io.ktor.client.plugins.*
import kotlinx.io.IOException

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Failure(val error: PhotoError) : ResponseResult<Nothing>()

    // 팩토리 메소드 정의
    companion object {
        fun <T> success(data: T): ResponseResult<T> = Success(data)
        fun failure(error: PhotoError): ResponseResult<Nothing> = Failure(error)
    }
}

sealed class PhotoError {
    data object NetworkError : PhotoError()
    data object EmptyQuery : PhotoError()
    data class ServerError(val message: String) : PhotoError()
}

// 공통되는 error catching
suspend fun <T> safeCall(call: suspend () -> T): ResponseResult<T> {
    return runCatching {
        call()
    }.fold(  // 성공인경우 T에 대한 Success, 실패인경우 PhotoError 반환
        onSuccess = { ResponseResult.success(it) },
        onFailure = {
            // Throwable을 PhotoError로 변환
            ResponseResult.failure(catchingError(it))
        }
    )
}

// Throwable을 PhotoError로 매핑하는 함수
fun catchingError(e: Throwable): PhotoError {
    return when (e) {
        is IOException -> PhotoError.NetworkError
        is ServerResponseException -> PhotoError.ServerError("서버 에러")
        is java.lang.IllegalArgumentException -> PhotoError.EmptyQuery
        else -> PhotoError.ServerError(e.message ?: "Unknown error")
    }
}
