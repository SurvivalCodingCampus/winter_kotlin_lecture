package org.example.day17.datasource

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.jsonConfig
import org.example.day17.dto.MaskStoresResponse
import org.example.day17.dto.asMaskStore
import org.example.day17.dto.isValidDate
import org.example.day17.model.MaskStore

const val MASK_STORES_URL =
    "https://gist.githubusercontent.com/junsuk5/2b34223fb2368d2bf44c85082745649a/raw/00cb276cb4f4f9573d868e88382f6f7f6759df31/mask_store.json"

class MaskStoreDataSourceImpl(
    private val httpClient: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(jsonConfig)
        }
    }
) : MaskStoreDataSource {
    override suspend fun getMaskStores(): Flow<List<MaskStore>> = flow {
        val stores = httpClient.get(MASK_STORES_URL).body<MaskStoresResponse>().stores
        if (stores.isNullOrEmpty()) {
            throw IllegalArgumentException("서버의 stores 값이 null 이거나 비어있습니다.")
        }

        val validatedStore = stores.filter { it.isValidDate() }
        if (validatedStore.isEmpty()) {
            throw IllegalArgumentException("서버의 유효한 store 이 없습니다.")
        }

        emit(validatedStore.map { it.asMaskStore() })
    }
}