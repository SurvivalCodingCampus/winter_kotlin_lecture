package org.example.day17.model

import java.time.LocalDateTime

data class Store(
    val address: String,
    val code: Int,
    val createAt: LocalDateTime,
    val name: String,
    val remainState: RemainState,
)

enum class RemainState {
    PLENTY,        // 100개 이상
    SOME,          // 30개 이상 100개 미만
    FEW,           // 2개 이상 30개 미만
    EMPTY,         // 1개 이하
    BREAK,          // 판매 중지
    UNKNOWN;        // 알수없음

    companion object {
        fun fromString(value: String?): RemainState {
            return when (value) {
                "plenty" -> PLENTY
                "some" -> SOME
                "few" -> FEW
                "empty" -> EMPTY
                "break" -> BREAK
                else -> UNKNOWN
            }
        }
    }
}