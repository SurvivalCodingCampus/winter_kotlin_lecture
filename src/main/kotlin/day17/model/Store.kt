package day17.model

import kotlinx.datetime.LocalDateTime


data class Store(
    val name: String,
    val fullAddress: String,
    val coordinates: Coordinates,
    val lastChecked: LocalDateTime,
    val stockedTime: LocalDateTime,
    val remaining: Amount,
) {
    enum class Amount(val range: IntRange) {
        PLENTY(100..<Int.MAX_VALUE),
        SOME(30..<100),
        FEW(2..<30),
        EMPTY(1..<2),
        BREAK(0..0),
        UNKNOWN(IntRange.EMPTY);

        companion object {
            fun of(key: String) = when (key.lowercase()) {
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
