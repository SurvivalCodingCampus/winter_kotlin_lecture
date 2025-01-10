package com.survivalcoding.day17.util

enum class NetworkError {
    NO_INTERNET,
    UNKNOWN,
}

sealed class Result<out D> {
    data class Success<D>(val data: D) : Result<D>()
    data class Error(val e: NetworkError) : Result<Nothing>()
}


