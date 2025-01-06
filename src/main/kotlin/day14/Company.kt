package org.example.day14

import kotlinx.serialization.Serializable

@Serializable
data class Company (
    val name: String,
    val catchPhrase: String,
    val bs: String,
)