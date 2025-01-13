package org.hyunjung.day18.model

sealed class PhotoError {
    object NetworkError : PhotoError()
    object EmptyQuery : PhotoError()
    data class ServerError(val message: String) : PhotoError()
}