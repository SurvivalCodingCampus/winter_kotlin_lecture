package org.hyunjung.day11

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val email: String
)