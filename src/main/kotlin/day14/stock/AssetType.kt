package org.example.day14.stock

enum class AssetType {
    STOCK,
    ETF,
    UNKNOWN;

    companion object {
        fun fromString(value: String?): AssetType {
            return when (value?.uppercase()) {
                "STOCK" -> STOCK
                "ETF" -> ETF
                else -> UNKNOWN
            }
        }
    }
}