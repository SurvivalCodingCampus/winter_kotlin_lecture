package day18.dto

import kotlinx.serialization.Serializable


// Image DTO
@Serializable
data class ImageResponse(
    val total: Long? = null,
    val totalHits: Long? = null,
    val hits: List<PhotoDto>? = null
)

@Serializable
data class PhotoDto(
    val id: Long? = null,
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
    val imageWidth: Int? = null,
    val imageHeight: Int? = null,
    val imageSize: Long? = null,
    val views: Long? = null,
    val downloads: Long? = null,
    val collections: Long? = null,
    val likes: Long? = null,
    val comments: Long? = null,
    val user_id: Long? = null,
    val user: String? = null,
    val userImageURL: String? = null
)