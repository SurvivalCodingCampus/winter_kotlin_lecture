package org.hyunjung.day17.maskstore.repository

import org.hyunjung.day17.maskstore.datasource.MaskStoreDataSource
import org.hyunjung.day17.maskstore.mapper.MaskStoreMapper
import org.hyunjung.day17.maskstore.model.Store

class MaskStoreRepository(
    private val dataSource: MaskStoreDataSource
) {

    suspend fun getStores(): List<Store> {
        val response = dataSource.getStores()
        return response.stores
            .mapNotNull { MaskStoreMapper.map(it) }
    }
}