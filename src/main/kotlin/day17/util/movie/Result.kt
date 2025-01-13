package org.example.day17.util.movie

sealed class Result<out D> {
    data class Success<D>(val data: D) : Result<D>()
    data class Error(val e: Throwable) : Result<Nothing>()
}
