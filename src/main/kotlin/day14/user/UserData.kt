package org.example.day14.user

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val id: Int?,
    val name: String?,
    val username: String?,
    val email: String?,
    val address: AddressData?,
    val phone: String?,
    val website: String?,
    val company: CompanyData?
)

@Serializable
data class AddressData(
    val street: String?,
    val suite: String?,
    val city: String?,
    val zipcode: String?,
    val geo: GeoData?
)

@Serializable
data class GeoData(
    val lat: String?,
    val lng: String?
)

@Serializable
data class CompanyData(
    val name: String?,
    val catchPhrase: String?,
    val bs: String?
)