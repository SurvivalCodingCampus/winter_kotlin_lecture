package day18.datasource

import day18.PhotoError
import day18.dto.PhotoDto
import day18.dto.PixabayResponse
import day18.util.ApiClient
import day18.util.Result
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.network.*
import kotlinx.io.IOException
import java.nio.file.Path
import kotlin.io.path.readLines

class PixabayDataSource(
    private val apiKey: String
    = Path.of("local.properties").readLines().first()
        .split('=').last(),
    httpClientEngine: HttpClientEngine = CIO.create()
) : PhotoDataSource {
    private val client = ApiClient(httpClientEngine).httpClient

    override suspend fun getPhotos(query: String): Result<List<PhotoDto>> {
        val response = try {
            client.get(LINK) {
                url {
                    parameters.append("key", apiKey)
                    parameters.append("q", query)
                    parameters.append("pretty", "true")
                }
            }
        } catch (e: Throwable) {
            when (e) {
                is UnresolvedAddressException, is IOException -> return Result.Error(PhotoError.NetworkError)
                else -> {
                    throw e
                }
            }
        }
        return when {
            response.status.isSuccess() -> {
                Result.Success(response.body<PixabayResponse>().hits ?: emptyList())
            }

            response.status.value in 500..599 -> {
                Result.Error(PhotoError.ServerError("Server responded with code: ${response.status.value}"))
            }

            else -> Result.Error(PhotoError.NetworkError)
        }

    }

    companion object {
        const val LINK = "https://pixabay.com/api/"
    }
}