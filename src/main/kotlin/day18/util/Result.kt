package day18.util

sealed class Result<out D> {
    data class Success<out D>(val data: D): Result<D>()
    data class Error(val e: PhotoError): Result<Nothing>()
}

sealed class PhotoError {
    object NetworkError: PhotoError()
    object EmptyQuery: PhotoError()
    data class ServerError(val message: String): PhotoError()
}