package day17

import Store

interface PharmacyDataSource {
    suspend fun fetchStoreData(url: String): List<Store>
}

