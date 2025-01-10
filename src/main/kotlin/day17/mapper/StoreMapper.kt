import day17.PharmacyDto
import day17.StoreDto


fun PharmacyDto.toPharmacy(): Pharmacy {
    return Pharmacy(
        count = count ?: 0, // PharmacyDto에 count 필드가 있다고 가정
        stores = stores?.map { storeDto -> storeDto.toStore() } ?: emptyList()
    )
}

fun StoreDto.toStore(): Store {
    return Store(
        address = addr ?: "",
        code = code ?: "",
        createdAt = createdAt ?: "",
        lat = lat ?: 0.0,
        lng = lng ?: 0.0,
        name = name ?: "",
        remainStat = remainStat ?: "",
        stockAt = stockAt ?: "",
        type = type ?: "type01"
    )
}
