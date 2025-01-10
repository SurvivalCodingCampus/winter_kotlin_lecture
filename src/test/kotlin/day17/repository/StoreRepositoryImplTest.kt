package day17.repository

import day17.data_source.StoreDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class StoreRepositoryImplTest {

    @Test
    fun getUsableStoreData() = runBlocking {
        val storeRepositoryImpl = StoreRepositoryImpl(StoreDataSourceImpl())

        val storeList = storeRepositoryImpl.getUsableStoreData()

        storeList.forEach {
            assertNotEquals(null, it.remainStat)
            assertNotEquals("", it.remainStat)
            assertNotEquals(null, it.stockAt)
            assertNotEquals("", it.stockAt)
            assertNotEquals(null, it.createdAt)
            assertNotEquals("", it.createdAt)
        }
    }
}