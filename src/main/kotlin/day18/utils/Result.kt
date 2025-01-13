package day18.utils

sealed class Result<out D> {
    data class Success<out D>(val data: D) : Result<D>()
    data class Error(val e: PhotoError) : Result<Nothing>()
}

/*
enum class NetworkError {
    NO_INTERNET,
    UNKNOWN,
}
*/

/*sealed class PhotoError : Exception() {
    object NetworkError : PhotoError()
    object EmptyQuery : PhotoError()
    data class ServerError(override val message: String) : PhotoError()
}*/

sealed class PhotoError : Throwable() {
    object NetworkError : PhotoError()
    object EmptyQuery : PhotoError()
    object EmptyPhoto : PhotoError()
    data class ServerError(override val message: String) : PhotoError()
    data class ClientError(override val message: String) : PhotoError()
}
