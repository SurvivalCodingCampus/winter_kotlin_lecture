package org.example.day17.model.photo

import java.time.LocalDate

data class Photo(
    val id: Int,
    val type: String,
    val title: String,
    val content: String,
    val url: String,
    val caption: String,
    val createdAt: LocalDate,
)