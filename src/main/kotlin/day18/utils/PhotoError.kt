package day18.utils

import io.ktor.client.plugins.*
import kotlinx.io.IOException

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Failure(val error: PhotoError) : ResponseResult<Nothing>()

//    // 팩토리 메소드 정의
//    companion object {
//        fun <T> success(data: T): ResponseResult<T> = Success(data)
//        fun failure(error: PhotoError): ResponseResult<Nothing> = Failure(error)
//    }
}

sealed class PhotoError {
    data object NetworkError : PhotoError()
    data object EmptyQuery : PhotoError()
    data class ServerError(val message: String) : PhotoError()
    data class UnknownError(val message: String) : PhotoError()
}

// 공통되는 error catching
suspend fun <T> safeCall(call: suspend () -> T): ResponseResult<T> {
    return runCatching {
        call()
    }.fold(  // 성공인경우 T에 대한 Success, 실패인경우 PhotoError 반환
        onSuccess = { ResponseResult.Success(it) },
        onFailure = {
            // Throwable을 PhotoError로 변환
            ResponseResult.Failure(catchingError(it))
        }
    )
}

// Throwable을 판단하고 들어온 Exception에 따라 알맞는 PhotoError로 리턴
fun catchingError(e: Throwable): PhotoError {
    return when (e) {
        is IOException -> PhotoError.NetworkError
        is ServerResponseException -> PhotoError.ServerError("서버 에러")
        is java.lang.IllegalArgumentException -> PhotoError.EmptyQuery
        else -> PhotoError.UnknownError(e.message ?: "Unknown Error")
    }
}
