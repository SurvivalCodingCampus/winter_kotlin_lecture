package org.example.day17.model

// 외부라이브러리 의존성 없고
// String 말고 LocalDateTime으로 받아도되고 가장 쓰기 편하게
data class Store(
    val addr: String,
    val createdAt: String?,
    val lat: Double,
    val lng: Double,
    val name: String,
    val remainStat: String?,
    val stockAt: String?
)
