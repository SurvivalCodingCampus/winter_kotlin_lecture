package day17.repository

import day17.data_source.StoreDataSource
import day17.data_source.StoreDataSourceImpl
import day17.mapper.toStore
import day17.model.Store
import kotlinx.coroutines.runBlocking

interface StoreRepository {
    suspend fun getUsableStoreData(): List<Store>
}

class StoreRepositoryImpl(private val dataSource: StoreDataSource): StoreRepository {
    override suspend fun getUsableStoreData(): List<Store> {
        return dataSource.getStoreList().map {
            it.toStore()
        }.filter {
            it.remainStat != "" && it.stockAt != "" && it.createdAt != ""
        }
    }

}

fun main() = runBlocking {
    val storeRepositoryImpl = StoreRepositoryImpl(StoreDataSourceImpl())

    val storeList = storeRepositoryImpl.getUsableStoreData()

    println(storeList)
}