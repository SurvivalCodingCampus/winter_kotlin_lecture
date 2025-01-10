package org.example.day18.error

sealed class EmailError : Exception() {
    object EmptyEmail : EmailError()
    object NoAtSign : EmailError()
    object InvalidDomain : EmailError()
    data class UnexpectedError(override val message: String) : EmailError()
}