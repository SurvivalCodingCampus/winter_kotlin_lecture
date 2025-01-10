package org.hyunjung.day17.photo.model

import java.time.LocalDate

data class Image(
    override val id: String,
    override val type: PhotoType,
    override val createdAt: LocalDate,
    val url: String,
    val caption: String
) : Photo()