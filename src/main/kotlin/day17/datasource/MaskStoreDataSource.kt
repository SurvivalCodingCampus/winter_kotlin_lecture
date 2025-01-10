package org.example.day17.datasource

import kotlinx.coroutines.flow.Flow
import org.example.day17.model.MaskStore

interface MaskStoreDataSource {
    suspend fun getMaskStores():Flow<List<MaskStore>>
}