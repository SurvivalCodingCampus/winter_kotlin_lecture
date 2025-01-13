package org.example.day18.util

sealed class PhotoError {
    object NetworkError : PhotoError()
    object EmptyQuery : PhotoError()
    data class ServerError(val message: String) : PhotoError()
}