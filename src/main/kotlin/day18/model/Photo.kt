package org.example.day18.model

data class Photo(
    val tags: List<String>,
    val imageUrl: String,
)

enum class PhotoOrder(val value: String) {
    LATEST("latest"),
    POPULAR("popular"),
}