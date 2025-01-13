package utils.network

// Result를 정의하여 받은 Response들의 결과가 정해진 규칙을 따르도록 함
sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Failure(val exception: Throwable) : ResponseResult<Nothing>()

    // 팩토리 메소드 정의
    companion object {
        fun <T> success(data: T): ResponseResult<T> = Success(data)
        fun failure(exception: Throwable): ResponseResult<Nothing> = Failure(exception)
    }
}

// 공통되는 error catching
suspend fun <T> safeCall(call: suspend () -> T): ResponseResult<T> {
    return runCatching {
        call()
    }.fold(     // 성공인경우 T에 대한 Success, 실패인경우 Throwable 반환
        onSuccess = { ResponseResult.success(it) },
        onFailure = { ResponseResult.failure(it) }
    )
}
