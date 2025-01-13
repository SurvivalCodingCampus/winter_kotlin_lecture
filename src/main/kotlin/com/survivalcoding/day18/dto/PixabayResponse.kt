package com.survivalcoding.day18.dto

data class PixabayResponse(
    val total: Int? = null,
    val totalHits: Int? = null,
    val hits: List<PhotoDto>? = null
)

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
    val likes: Int? = null,
    val comments: Int? = null,
    val user_id: Long? = null,
    val user: String? = null,
    val userImageURL: String? = null
)