package day17.data_source

import day17.dto.StoreDto

interface StoreDataSource {
    suspend fun getStoreInfoList(): List<StoreDto>
}