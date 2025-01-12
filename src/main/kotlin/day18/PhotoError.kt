package day18

sealed class PhotoError {
    data class ServerError(val message: String) : PhotoError()
    data object NetworkError : PhotoError()
    data object EmptyQuery : PhotoError()
}