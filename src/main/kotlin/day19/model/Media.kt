package day19.model

import io.ktor.http.*

sealed class Media(val url: Url) {
    class Image(url: Url): Media(url)
    class Video(url: Url): Media(url)
}
