package org.example.day17.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.day17.data_source.StoreDataSource
import org.example.day17.mapper.toModel
import org.example.day17.model.Store

class StoreRepositoryImpl(override val dataStore: StoreDataSource) : StoreRepository {
    override suspend fun getStores(): List<Store> = withContext(Dispatchers.IO) {
        try {
            dataStore.getStores()
                .filter { !it.created_at.isNullOrEmpty() && !it.remain_stat.isNullOrEmpty() && !it.stock_at.isNullOrEmpty() }
                .map { it.toModel() }
        } catch (e: Exception) {
            when (e) {
                is IllegalArgumentException, is IllegalStateException -> throw e
                else -> emptyList()
            }
        }
    }
}