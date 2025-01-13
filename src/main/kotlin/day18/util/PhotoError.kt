package day18.util

sealed class PhotoError: Exception() {

    data object NetworkError : PhotoError() {
        private fun readResolve(): Any = NetworkError
    }

    data object EmptyQuery : PhotoError() {
        private fun readResolve(): Any = EmptyQuery
    }

    data class ServerError(override val message: String) : PhotoError()
}

