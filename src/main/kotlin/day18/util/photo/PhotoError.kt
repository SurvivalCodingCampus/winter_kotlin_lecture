package org.example.day18.util.photo

sealed class PhotoError {
    object NetWorkError : PhotoError()
    object EmptyQuery : PhotoError()
    data class ServerError(val message: String) : PhotoError()
}