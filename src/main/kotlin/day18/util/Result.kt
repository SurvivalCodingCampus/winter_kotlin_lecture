package day18.util

import day18.PhotoError

sealed class Result<out T> {
    class Success<out T>(val data: T) : Result<T>()
    class Error(val error: PhotoError) : Result<Nothing>()
}
