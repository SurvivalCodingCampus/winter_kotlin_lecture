package org.hyunjung.day17.photo.model

import java.time.LocalDate

sealed class Photo {
    abstract val id: Int
    abstract val createdAt: LocalDate
}
