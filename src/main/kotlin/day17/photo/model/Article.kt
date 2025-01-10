package org.hyunjung.day17.photo.model

import java.time.LocalDate

data class Article(
    override val id: String,
    override val type: PhotoType,
    override val createdAt: LocalDate,
    val title: String,
    val content: String
) : Photo()