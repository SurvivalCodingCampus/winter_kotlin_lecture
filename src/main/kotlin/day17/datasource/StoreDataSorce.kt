package org.example.day17.datasource

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.example.day17.dto.StoreDto
import org.example.day17.dto.StoreResponse

interface StoreDataSorce {
    suspend fun getStores(): List<StoreDto>
}

class StoreDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : StoreDataSorce {


    override suspend fun getStores(): List<StoreDto> {
        val json = Json { ignoreUnknownKeys = true }
        val response =
            client.get("https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json")
                .bodyAsText()
        val storeResult = json.decodeFromString<StoreResponse>(response)
        return storeResult.stores
    }
}