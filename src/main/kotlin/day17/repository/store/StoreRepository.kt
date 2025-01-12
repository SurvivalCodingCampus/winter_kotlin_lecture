package org.example.day17.repository.store

import Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}
