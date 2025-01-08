package day15.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    // val address: String,
    val phone: String,
    val website: String,
    //val company: String
)