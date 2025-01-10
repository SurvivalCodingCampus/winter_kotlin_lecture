package com.survivalcoding.day17.util

enum class NetworkError {
    NO_INTERNET,
    UNKNOWN,
}

sealed class Result<out D> {
    data class Success<out D>(val data: D) : Result<D>()
    data class Error(val e: NetworkError) : Result<Nothing>()
}


sealed class Result2<out D, out E> {
    data class Success<out D>(val data: D) : Result2<D, Nothing>()
    data class Error<out E>(val error: E) : Result2<Nothing, E>()
}

