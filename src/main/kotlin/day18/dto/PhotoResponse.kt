package org.example.day18.dto

import kotlinx.serialization.Serializable
import org.example.day18.model.Photo

@Serializable
data class PhotoResponse(
    val id: Long,
    val pageURL: String,
    val type: String,
    val tags: String,
    val previewURL: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageURL: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Long,
    val views: Int,
    val downloads: Int,
    val collections: Int,
    val likes: Int,
    val comments: Int,
    val user_id: Long,
    val user: String,
    val userImageURL: String
)

fun PhotoResponse.asExternalModel() = Photo(
    id = id,
    tags = tags.split(", "),
    imageUrl = webformatURL
)