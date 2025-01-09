package org.example.day17.repository

import org.example.day17.datasource.StoreDataSorce
import org.example.day17.mapper.toStore
import org.example.day17.model.Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}

class StoreRepositoryImpl(private val dataSource: StoreDataSorce) : StoreRepository {
    override suspend fun getStores(): List<Store> {
        return dataSource.getStores()
            .map { it.toStore() }
            .filter { it.remainStat != "" }
            .filter { it.stockAt != "" }
            .filter { it.createdAt != "" }
    }
}