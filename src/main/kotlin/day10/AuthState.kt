package org.example.day10

//class AuthState {
//    companion object {
//        const val AUTHENTICATED = 1
//        const val UNAUTHORIZED = 2
//        const val UNKNOWN = 3
//    }
//}

// enum class 사용
// enum 클래스는 when과 조합으로 모든 처리를 강제할 수 있음
enum class AuthState{
    AUTHENTICATED, UNAUTHORIZED, UNKNOWN
}