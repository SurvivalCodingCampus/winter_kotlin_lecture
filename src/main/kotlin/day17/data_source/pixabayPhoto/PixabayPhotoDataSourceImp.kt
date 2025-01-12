package org.example.day17.data_source.pixabayPhoto

import Constants
import PixabayResponse
import RResult
import day17.PhotoError
import day17.PixabayPhoto
import day17.toPixabayModel
import extractKey
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.network.*
import kotlinx.io.IOException
import org.example.day15.Utils.format


class PixabayPhotoDataSourceImp(
    private val httpClient: HttpClient,
    private val apiKey: String = Constants.KEY
) : PixabayPhotoDataSource {
    override suspend fun getPhotos(query: String): RResult<List<PixabayPhoto>, PhotoError> {
        if (query.isBlank()) return RResult.Error(PhotoError.EmptyQuery)

        return try {
            val response = httpClient.get("${Constants.BASE_URL}?key=${apiKey}&q=${query}&image_type=photo&pretty=true")

            when (response.status) {
                HttpStatusCode.OK -> {
                    RResult.Success(
                        format.decodeFromString<PixabayResponse>(response.bodyAsText()).toPixabayModel().images
                    )
                }

                HttpStatusCode.NotFound -> {
                    RResult.Error(PhotoError.NetworkError)
                }

                HttpStatusCode.BadRequest -> {
                    if (response.bodyAsText()
                            .contains("Invalid API key")
                    ) RResult.Error(PhotoError.ServerError.ApiKeyError("api 잘못됨"))
                    else RResult.Error(PhotoError.ServerError.BadRequest("400 error"))
                }

                HttpStatusCode.InternalServerError -> {
                    RResult.Error(PhotoError.ServerError.InternalServerError("Internal Server Error"))
                }

                else -> {
                    RResult.Error(PhotoError.ServerError.UnknownError("예상치 못한 에러"))
                }
            }
        } catch (e: IOException) {
            RResult.Error(PhotoError.ServerError.IOException("IOException Error"))
        } catch (e: UnresolvedAddressException) {
            RResult.Error(PhotoError.NetworkError)
        } catch (e: Exception) {
            RResult.Error(PhotoError.ServerError.UnknownError("Unexpected Error :${e}"))
        }
    }

}