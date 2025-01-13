package day19.model

// Filter 관련 Enum
enum class TimeType {
    ALL, NEWEST, OLDEST, POPULARITY
}

enum class Rate(
    val score: Int
) {
    NOT_BAD(1), BAD(2), NORMAL(3), GOOD(4), VERY_GOOD(5)
}
