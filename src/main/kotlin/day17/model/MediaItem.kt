package day17.model

import kotlinx.datetime.LocalDate

class MediaItem(
    val id: Int,
    val type: MediaType,
    val createdAt: LocalDate,
    val summary: String,
    val resource: String,
)
