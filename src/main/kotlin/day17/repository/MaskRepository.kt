package day17.repository

import day17.dto.StoreDto
import day17.model.Store

interface MaskRepository {
    suspend fun getUseStoreData(): List<Store>
}