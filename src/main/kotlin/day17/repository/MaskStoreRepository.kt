package day17.repository

import day17.dto.MaskStoreDto
import day17.model.Pharmacy

interface MaskStoreRepository {
    suspend fun getValidStore(): List<Pharmacy>
}
