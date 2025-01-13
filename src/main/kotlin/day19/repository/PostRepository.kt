package day19.repository

import io.ktor.http.*
import java.util.UUID


interface PostRepository {
    fun getShareableLink(id: UUID): Url
}