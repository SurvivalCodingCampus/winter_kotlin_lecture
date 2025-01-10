package day17

import Store

interface StoreRepository {
    suspend fun getStores(): List<Store>
}
