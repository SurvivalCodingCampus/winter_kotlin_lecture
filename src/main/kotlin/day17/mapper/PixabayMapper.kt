package day17

import ImageHit
import PixabayResponse

fun PixabayResponse.toPixabayModel(): PixabayModel {
    return PixabayModel(
        total = total ?: 0,
        totalHits = totalHits ?: 0,
        images = hits?.map { it.toImage() } ?: emptyList()
    )
}

fun ImageHit.toImage(): PixabayPhoto {
    return PixabayPhoto(
//        id = id ?: 0,
        imageUrl = imageUrl ?: largeImageUrl ?: "",
//        type = type ?: "",
        tags = tags?.split(", ") ?: emptyList(),
//        previewUrl = previewUrl ?: "",
//        previewWidth = previewWidth ?: 0,
//        previewHeight = previewHeight ?: 0,
//        webformatUrl = webformatUrl ?: "",
//        webformatWidth = webformatWidth ?: 0,
//        webformatHeight = webformatHeight ?: 0,
//        largeImageUrl = largeImageUrl ?: "",
//        fullHdUrl = fullHdUrl ?: "",
//        imageUrl = imageUrl ?: "",
//        imageWidth = imageWidth ?: 0,
//        imageHeight = imageHeight ?: 0,
//        imageSize = imageSize ?: 0,
//        views = views ?: 0,
//        downloads = downloads ?: 0,
//        likes = likes ?: 0,
//        comments = comments ?: 0,
//        user = toUserInfo()
    )
}

fun ImageHit.toUserInfo(): UserInfo {
    return UserInfo(
        id = userId ?: 0,
        name = user ?: "",
        imageUrl = userImageUrl ?: ""
    )
}