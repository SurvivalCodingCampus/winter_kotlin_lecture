package org.example.day17.data_source.store

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.example.day17.dto.store.StoreDTO
import org.example.day17.dto.store.StoreResult


class StoreDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO),
) : StoreDataSource {
    private val url =
        "https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json"

    override suspend fun getAllStoreData(): List<StoreDTO> {
        val stores = Json.decodeFromString<StoreResult>(client.get(url).bodyAsText()).stores ?: return emptyList()

        return stores
    }
}