package org.hyunjung.day17.photo.model

import java.time.LocalDate

sealed class Photo {
    abstract val id: String
    abstract val type: PhotoType
    abstract val createdAt: LocalDate
}
