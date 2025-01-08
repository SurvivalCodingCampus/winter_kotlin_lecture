package org.example.day15.repository_exam.data_source

import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.model.Post
import java.io.File

class MockPostDatasourceImpl : PostDatasource {
    private val filePath = "posts.txt"
    private val file = File(filePath)

    override suspend fun getPost(id: Int): Post {
        return Json.decodeFromString<List<Post>>(file.readText()).filter { it.id == id }[0]
    }

    override suspend fun savePost(post: Post) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllPosts(): List<Post> {
        return Json.decodeFromString<List<Post>>(file.readText())
    }
}