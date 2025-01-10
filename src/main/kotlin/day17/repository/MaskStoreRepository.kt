package org.example.day17.repository

import kotlinx.coroutines.flow.Flow
import org.example.day17.model.MaskStore

interface MaskStoreRepository {
    suspend fun getMaskStores(): Flow<List<MaskStore>>
}