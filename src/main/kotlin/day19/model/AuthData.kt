package org.hyunjung.day19.model

data class AuthData(
    val token: String,
    val refreshToken: String,
    val userId: Int,
)