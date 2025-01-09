package day17.datasource

import day16.data.Data
import day17.dto.MaskResponse
import day17.dto.StoreDto
import io.ktor.client.call.*
import io.ktor.client.request.*

class StoreDataStoreImpl : StoreDataStore {
    override suspend fun getStoreData(): List<StoreDto> {
        val response =
            Data.client.get("https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json")
                .body<MaskResponse>()
        return response.stores ?: emptyList()
    }
}