package org.example.day17.repository.store

import org.example.day17.data_source.store.StoreDataSource
import org.example.day17.mapper.store.toStore
import org.example.day17.model.store.Store

class StoreRepositoryImpl(private val dataSource: StoreDataSource) : StoreRepository {
    override suspend fun getVailidStoreData(): List<Store> {
        return dataSource.getAllStoreData().map { it.toStore() }
            .filter { it.remainStat != "" && it.stockAt != "" && it.createdAt != "" }
    }
}