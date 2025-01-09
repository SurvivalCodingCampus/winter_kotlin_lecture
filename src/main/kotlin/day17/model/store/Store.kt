package org.example.day17.model.store

data class Store(
    val addr: String,
    val code: String,
    val createdAt: String,
    val lat: Double,
    val lng: Double,
    val name: String,
    val remainStat: String,
    val stockAt: String,
    val type: String,
)