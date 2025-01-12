package org.example.day17.data_source.pharmacy

import Store

interface PharmacyDataSource {
    suspend fun fetchStoreData(url: String): List<Store>
}

