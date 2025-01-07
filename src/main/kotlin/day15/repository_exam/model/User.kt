package org.example.day15.repository_exam.model

import kotlinx.serialization.Serializable
import org.example.day15.repository_exam.model.user.Address
import org.example.day15.repository_exam.model.user.Company

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
)