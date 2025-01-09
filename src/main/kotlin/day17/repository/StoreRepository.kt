package day17.repository

import day17.model.Store

interface StoreRepository {
    suspend fun getAll(): List<Store>
}