package day18.dto

import kotlinx.serialization.Serializable

@Serializable
data class PixabayResponseDto(
    val total: Int? = null,
    val totalHits: Int? = null,
    val hits: List<PhotoDto>? = null
)

@Serializable
data class PhotoDto(
    val id: Int? = null,
    val pageURL: String? = null,
    val type: String? = null,
    val tags: String? = null,
    val previewURL: String? = null,
    val previewWidth: Int? = null,
    val previewHeight: Int? = null,
    val webformatURL: String? = null,
    val webformatWidth: Int? = null,
    val webformatHeight: Int? = null,
    val largeImageURL: String? = null,
    val fullHDURL: String? = null,
    val imageURL: String? = null,
    val imageWidth: Int? = null,
    val imageHeight: Int? = null,
    val imageSize: Int? = null,
    val views: Int? = null,
    val downloads: Int? = null,
    val likes: Int? = null,
    val comments: Int? = null,
    val user_id: Int? = null,
    val user: String? = null,
    val userImageURL: String? = null
)
