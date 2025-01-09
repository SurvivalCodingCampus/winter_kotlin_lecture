package org.example.day17.model

import java.time.LocalDate

class MaskStore(
    val address: String,
    val code: String,
    val createdDate: LocalDate,
    val lat: Double,
    val lng: Double,
    val name: String,
    val remainStat: String,
    val stockDate: LocalDate,
    val type: String
)