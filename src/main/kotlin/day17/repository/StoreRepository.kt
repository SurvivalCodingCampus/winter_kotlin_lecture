package org.example.day17.repository

import org.example.day17.data_source.StoreDataSource
import org.example.day17.model.Store

interface StoreRepository {
    val dataStore: StoreDataSource
    suspend fun getStores(): List<Store>
}