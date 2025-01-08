package org.example.day15.Model

import kotlinx.serialization.Serializable

sealed class Entities {}

@Serializable
data class Comment(val postId: Int, val id: Int, val name: String, val email: String, val body: String) :
    Entities() {}

@Serializable
data class Photo(val albumId: Int, val id: Int, val title: String, val thumbnailUrl: String) : Entities() {}

@Serializable
data class Todo(val userId: Int, val id: Int, val title: String, val completed: Boolean) : Entities() {}

@Serializable
data class Post(val userId: Int, val id: Int, val title: String, val body: String) : Entities() {}

@Serializable
data class Album(val userId: Int, val id: Int, val title: String) : Entities() {}

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
) : Entities()

@Serializable
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

@Serializable
data class Geo(
    val lat: String,
    val lng: String
)

@Serializable
data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

