package org.example.day16.repository_exam.model.image

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val byteArray: ByteArray,
)