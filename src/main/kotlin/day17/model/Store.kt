package day17.model

import java.time.LocalDateTime

data class Store(
    val addr: String,
    val createdAt: String,
    val name: String,
    val remainStat: String,
    val stockAt: String,
    val type: StoreType
)

enum class StoreType {
    PHARMACY,
    POSTOFFICE,
    NA,
    ERROR
}