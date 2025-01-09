package org.example.day17.data_source

import day17.MaskStoreDto
import day17.StoreDto
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.day15.data_source.KtorClient

class StoreDataSourceImpl : StoreDataSource, KtorClient {
    override val baseUrl: String =
        "https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json"

    override suspend fun getStores(): List<StoreDto> = withContext(Dispatchers.IO) {
        try {
            defaultJson.decodeFromString<MaskStoreDto>(client.get(baseUrl).bodyAsText()).stores ?: emptyList()
        } catch (e: Exception) {
            throw e
        }
    }
}