package day17.dataSource

import day17.dto.MaskStoreDto
import day17.dto.Pharmacy
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class MaskStoreDataSourceImpl (
    private val client: HttpClient = HttpClient(CIO),
    private val apiUrl: String = "https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json"
): MaskStoreDataSource {
    override suspend fun getStores(): MaskStoreDto {
        val response: HttpResponse = client.get(apiUrl)
        return Json.decodeFromString<MaskStoreDto>(response.bodyAsText())
    }

    override suspend fun getStore(name: String): Pharmacy? {
        val matchedStore = getStores().stores?.find { it.name == name }
        if (matchedStore == null) {
            return null
        }
        return matchedStore

    }
}