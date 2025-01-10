package org.example.day17.data_source

import day17.StoreDto
import org.example.day15.data_source.DataSource

interface StoreDataSource : DataSource {
    suspend fun getStores(): List<StoreDto>
}