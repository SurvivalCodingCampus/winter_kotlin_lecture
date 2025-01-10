package day17.model

import java.time.LocalDate

data class Photo(
    val id: Int,
    val type: PhotoType,
    val title: String,
    val content: String,
    val createdAt: LocalDate
)
