package day17.data_source

import day17.dto.MaskStoreResponse
import day17.dto.StoreDto
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import java.lang.NullPointerException

interface StoreDataSource {
    suspend fun getStoreList(): List<StoreDto>
}

class StoreDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
): StoreDataSource {
    override suspend fun getStoreList(): List<StoreDto> {
        val data = Json.decodeFromString<MaskStoreResponse>(
            client.get("https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json").bodyAsText())

        return data.stores ?: throw NullPointerException("getStoreList")
    }
}