package day17.repository

import Store
import StoreRepositoryImpl
import day17.PharmacyDto
import day17.PharmacyDataSource
import kotlinx.coroutines.test.runTest
import org.example.day15.Utils.format
import org.junit.Test
import toStore

val mockJson = """
    { "count": 2, "stores": [ { "address": "123 Main St", "pharmacyCode": "PH123", "createdDate": "2025-01-01T10:00:00", "latitude": 37.7749, "longitude": -122.4194, "pharmacyName": "Health Pharmacy", "stockStatus": "plenty", "lastUpdated": "2025-01-02T14:00:00", "type": "pharmacy" }, { "address": "456 Market St", "pharmacyCode": "PH456", "createdDate": "2025-01-03T12:00:00", "latitude": 37.7849, "longitude": -122.4294, "pharmacyName": "Wellness Pharmacy", "stockStatus": "few", "lastUpdated": "2025-01-04T16:30:00", "type": null } ] }
""".trimIndent()

class StoreRepositoryImplTest {
    private val mockStoreDataSource = object : PharmacyDataSource {
        override suspend fun fetchStoreData(url: String): List<Store> {
            return format.decodeFromString<PharmacyDto>(mockJson).stores?.map { store -> store.toStore() }
                ?: emptyList()
        }
    }


    @Test
    fun `Store Repository`(): Unit = runTest {
        val repository = StoreRepositoryImpl(mockStoreDataSource)
        val stores = repository.getStores()


    }
}