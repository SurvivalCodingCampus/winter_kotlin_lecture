package day10

fun main() {
    val state = AuthState.UNAUTHENTICATED
    something(state)

}


enum class AuthState(val code: Int) {
    AUTHENTICATED(0), UNAUTHENTICATED(1), UNKNOWN(2)
}

fun something(authState: AuthState) {
    when (authState) {
        AuthState.AUTHENTICATED -> {
            println("AUTHENTICATED")
            println(authState.code)
        }

        AuthState.UNAUTHENTICATED -> {
            println("UNAUTHENTICATED")
            println(authState.code)
        }

        AuthState.UNKNOWN -> {
            println("UNKNOWN")
            println(authState.code)
        }
    }
}