package day17.repository

import day17.data_source.StoreDataSource
import day17.mapper.toStore
import day17.model.Store

class StoreRepositoryImpl(private val storeDataSource: StoreDataSource) : StoreRepository {
    override suspend fun getStoreInfoList(): List<Store> {
        return storeDataSource.getStoreInfoList()
            .map { it.toStore() }
            .filter {
                it.remainStat?.isNotBlank() == true &&
                it.stockAt?.isNotBlank() == true &&
                it.createdAt?.isNotBlank() == true
            }
    }
}