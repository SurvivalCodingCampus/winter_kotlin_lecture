package org.example.day14.stock

enum class Exchange {
    BATS,
    NYSE,
    NYSE_ARCA,
    NYSE_MKT,
    NASDAQ,
    UNKNOWN;

    companion object {
        fun fromString(value: String?): Exchange {
            return when (value?.uppercase()) {
                "BATS" -> BATS
                "NYSE" -> NYSE
                "NYSE ARCA" -> NYSE_ARCA
                "NYSE MKT" -> NYSE_MKT
                "NASDAQ" -> NASDAQ
                else -> UNKNOWN
            }
        }
    }
}