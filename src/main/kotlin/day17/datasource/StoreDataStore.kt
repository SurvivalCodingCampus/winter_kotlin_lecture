package day17.datasource

import day17.dto.StoreDto

interface StoreDataStore {
    suspend fun getStoreData(): List<StoreDto>
}