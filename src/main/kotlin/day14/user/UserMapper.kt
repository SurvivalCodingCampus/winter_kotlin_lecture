package org.example.day14.user

object UserMapper {
    val companyMapper = CompanyMapper
    val addressMapper = AddressMapper
    fun fromData(data: UserData?): User {
        if (data == null) {
            return User.init()
        }
        return User(
            id = data.id ?: -1,
            name = data.name ?: "",
            username = data.username ?: "",
            email = data.email ?: "",
            address = addressMapper.fromData(data.address),
            phone = data.phone ?: "",
            website = data.website ?: "",
            company = companyMapper.fromData(data.company)
        )
    }

    fun fromDataList(dataList: List<UserData>): List<User> {
        return dataList.map { fromData(it) }
    }
}

object CompanyMapper {
    fun fromData(data: CompanyData?): Company {
        if (data == null) {
            return Company.init()
        }
        return Company(
            name = data.name ?: "",
            catchPhrase = data.catchPhrase ?: "",
            bs = data.bs ?: ""
        )
    }
}

object AddressMapper {
    val geoMapper = GeoMapper
    fun fromData(data: AddressData?): Address {
        if (data == null) {
            return Address.init()
        }
        return Address(
            street = data.street ?: "",
            suite = data.suite ?: "",
            city = data.city ?: "",
            zipcode = data.zipcode ?: "",
            geo = geoMapper.fromData(data.geo)
        )
    }
}

object GeoMapper {
    fun fromData(data: GeoData?): Geo {
        if (data == null) {
            return Geo.init()
        }
        return Geo(
            lat = data.lat ?: "",
            lng = data.lng ?: ""
        )
    }
}