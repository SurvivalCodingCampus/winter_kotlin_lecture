package org.example.day17.repository.store

import org.example.day17.model.store.Store

interface StoreRepository {
    suspend fun getVailidStoreData(): List<Store>
}