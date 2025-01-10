package day17.dataSource

import day17.dto.PhotoDto

class MockPhotoDataSourceImpl : PhotoDataSource {
    override suspend fun getPhotoData(): List<PhotoDto> {
        val dummyPhotos = listOf(
            PhotoDto(
                id = "1",
                type = "article",
                title = "This is an article",
                content = "This is the content of the article.",
                createdAt = "2020-01-01"
            ),
            PhotoDto(
                id = "2",
                type = "image",
                content = "This is the content of the image.",
                url = "https://example.com/image.jpg",
                caption = "This is an image caption",
                createdAt = "2020-02-02"
            ),
            PhotoDto(
                id = "3",
                type = "video",
                url = "https://example.com/video.mp4",
                caption = "This is a video caption",
                createdAt = "2020-03-03"
            ),
            // Article 타입, 중복
            PhotoDto(
                id = "1",
                type = "article",
                title = "This is an article",
                content = "This is the content of the article.",
                createdAt = "2020-01-01"
            ),
            // null 타입, Unknown으로 처리
            PhotoDto(
                id = "2",
                type = null,
                url = "https://example.com/image.jpg",
                caption = "This is an image caption",
                createdAt = "2020-02-02"
            ),
            // type 없음, Unknown으로 처리
            PhotoDto(
                id = "3",
                url = "https://example.com/video.mp4",
                caption = "This is a video caption",
                createdAt = "2020-03-03"
            )
        )

        return dummyPhotos
    }
}
