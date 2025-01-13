package org.hyunjung.day18.util

sealed class Result<out D> {
    data class Success<D>(val data: D) : Result<D>()
    data class Error<E>(val message: E) : Result<Nothing>()
}