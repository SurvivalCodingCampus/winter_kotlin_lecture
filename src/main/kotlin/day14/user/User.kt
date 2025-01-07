package org.example.day14.user

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int = -1,
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val address: Address = Address.init(),
    val phone: String = "",
    val website: String = "",
    val company: Company = Company.init(),
) {
    companion object {
        fun init(): User {
            return User(
                id = -1,
                name = "",
                username = "",
                email = "",
                address = Address.init(),
                phone = "",
                website = "",
                company = Company.init()
            )
        }
    }
}

@Serializable
data class Company(
    val name: String = "",
    val catchPhrase: String = "",
    val bs: String = "",
) {
    companion object {
        fun init(): Company {
            return Company(
                name = "",
                catchPhrase = "",
                bs = ""
            )
        }
    }
}

@Serializable
data class Address(
    val street: String = "",
    val suite: String = "",
    val city: String = "",
    val zipcode: String = "",
    val geo: Geo = Geo.init(),
) {
    companion object {
        fun init(): Address {
            return Address(
                street = "",
                suite = "",
                city = "",
                zipcode = "",
                geo = Geo.init()
            )
        }
    }
}

@Serializable
data class Geo(
    val lat: String = "",
    val lng: String = "",
) {
    companion object {
        fun init(): Geo {
            return Geo(
                lat = "",
                lng = ""
            )
        }
    }
}
