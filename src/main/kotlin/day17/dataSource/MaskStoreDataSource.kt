package day17.dataSource

import day17.dto.MaskStoreDto
import day17.dto.Pharmacy

interface MaskStoreDataSource {
    suspend fun getStores(): MaskStoreDto
    suspend fun getStore(name: String): Pharmacy?
}