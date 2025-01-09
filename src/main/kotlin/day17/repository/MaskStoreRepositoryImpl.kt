package org.example.day17.repository

import kotlinx.coroutines.flow.Flow
import org.example.day17.datasource.MaskStoreDataSource
import org.example.day17.model.MaskStore

class MaskStoreRepositoryImpl(
    private val maskStoreDataSource: MaskStoreDataSource
) : MaskStoreRepository {
    override suspend fun getMaskStores(): Flow<List<MaskStore>> =
        maskStoreDataSource.getMaskStores()
}