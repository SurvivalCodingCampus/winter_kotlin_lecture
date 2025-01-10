package org.example.day18.util

interface EmailValidator {
    fun isValid(email: String): Result<Unit>
}