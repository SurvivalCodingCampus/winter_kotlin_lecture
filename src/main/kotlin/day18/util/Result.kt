package org.example.day18.util


sealed class Result<out D> {
    data class Success<D>(val data: D) : Result<D>()
    data class Error(val e: Exception) : Result<Nothing>()
}