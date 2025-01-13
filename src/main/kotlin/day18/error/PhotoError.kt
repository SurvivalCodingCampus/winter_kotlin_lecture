package org.example.day18.error

sealed class PhotoError : Exception() {
    data object NetworkError : PhotoError() {
        private fun readResolve(): Any = NetworkError
    }

    data object EmptyError : PhotoError() {
        private fun readResolve(): Any = EmptyError
    }

    data class ServerError(override val message: String) : PhotoError()
}