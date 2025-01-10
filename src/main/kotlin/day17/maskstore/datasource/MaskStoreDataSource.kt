package org.hyunjung.day17.maskstore.datasource

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import org.hyunjung.day17.ApiModule
import org.hyunjung.day17.maskstore.dto.MaskStoreResponse
import org.hyunjung.day17.maskstore.util.Constants

class MaskStoreDataSource(
    private val client: HttpClient = ApiModule.create()
) {
    suspend fun getStores(): MaskStoreResponse {
        val response =
            client.get(Constants.BASE_URL)
        return Json.decodeFromString<MaskStoreResponse>(response.body())
    }
}