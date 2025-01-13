package org.example.day17.data_source.photo

import Photo
import day17.PhotoDataSource
import day17.PhotoDto
import org.example.day15.Utils.format
import toPhoto


class MockPhotoDataSourceImpl : PhotoDataSource {
    private val mockJsonData =
        """ [ { "id": 1, "type": "article", "title": "This is an article", "content": "This is the content of the article.", "created_at": "2020-01-01" }, { "id": 2, "type": "image", "url": "https://example.com/image.jpg", "caption": "This is an image.", "created_at": "2020-02-02" }, { "id": 3, "type": "video", "url": "https://example.com/video.mp4", "caption": "This is a video.", "created_at": "2020-03-03" } ] """.trimIndent()

    override suspend fun getPhotos(): List<Photo> {
        val result = format.decodeFromString<List<PhotoDto>>(mockJsonData)

        return result.map { photo -> photo.toPhoto() }
    }

}