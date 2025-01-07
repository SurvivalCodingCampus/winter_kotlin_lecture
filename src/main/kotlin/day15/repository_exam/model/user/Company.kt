package org.example.day15.repository_exam.model.user

import kotlinx.serialization.Serializable

@Serializable
data class Company (
    val name: String,
    val catchPhrase: String,
    val bs: String,
)