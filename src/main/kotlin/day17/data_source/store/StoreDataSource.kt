package org.example.day17.data_source.store

import org.example.day17.dto.store.StoreDTO

interface StoreDataSource {
    suspend fun getAllStoreData() : List<StoreDTO>
}