package day18.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoDto(
    val collections: Int? = null,
    val comments: Int? = null,
    val downloads: Int? = null,
    val id: Int? = null,
    val imageHeight: Int? = null,
    val imageSize: Int? = null,
    val imageWidth: Int? = null,
    val largeImageURL: String? = null,
    val likes: Int? = null,
    val pageURL: String? = null,
    val previewHeight: Int? = null,
    val previewURL: String? = null,
    val previewWidth: Int? = null,
    val tags: String? = null,
    val type: String? = null,
    val user: String? = null,
    val userImageURL: String? = null,
    @SerialName("user_id")
    val userId: Int? = null,
    val views: Int? = null,
    val webformatHeight: Int? = null,
    val webformatURL: String? = null,
    val webformatWidth: Int? = null
)