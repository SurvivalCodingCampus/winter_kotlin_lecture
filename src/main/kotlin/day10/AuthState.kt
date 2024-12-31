package org.example.day10

enum class AuthState {
    AUTHENTICATED, UNAUTHENTICATED, UNKNOWN
}

fun something(authState: AuthState) {
    when(authState) {
        AuthState.AUTHENTICATED -> println("Authenticated")
        AuthState.UNAUTHENTICATED -> println("Unauthenticated")
        AuthState.UNKNOWN -> println("Unknown")
    }
}