package day15.model

import day14.AddressJson
import day14.Company
import kotlinx.serialization.Serializable

@Serializable
data class User (
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressJson,
    val phone: String,
    val website: String,
    val company: Company
)

@Serializable
data class AddressJson (
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

@Serializable
data class Geo (
    val lat: String,
    val lng: String
)