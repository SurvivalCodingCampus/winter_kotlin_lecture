package day17.repository

import day17.datasource.StoreDataStore
import day17.model.Store
import day17.toStore

class StoreRepositoryImpl(private val source: StoreDataStore) : StoreRepository {
    override suspend fun getAll(): List<Store> = source.getStoreData()
        .filter { !it.created_at.isNullOrBlank() && !it.stock_at.isNullOrBlank() && !it.remain_stat.isNullOrBlank() }
        .map { it.toStore() }
}