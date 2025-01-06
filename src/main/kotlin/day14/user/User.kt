package org.example.day14.user


data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
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

data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
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

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
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

data class Geo(
    val lat: String,
    val lng: String
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
