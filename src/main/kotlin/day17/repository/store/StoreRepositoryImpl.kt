package org.example.day17.repository.store

import Store
import org.example.day17.data_source.pharmacy.PharmacyDataSource
import org.example.day17.data_source.pharmacy.PharmacyDataSourceImpl


class StoreRepositoryImpl(
    private val dataSource: PharmacyDataSource = PharmacyDataSourceImpl()
) : StoreRepository {
    override suspend fun getStores(): List<Store> {
        val url =
            "https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json"
        return dataSource.fetchStoreData(url)
    }
}
