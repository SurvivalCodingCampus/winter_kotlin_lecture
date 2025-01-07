package org.example.day15.repository_exam.data_source

import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.model.Post
import java.io.File

class PostDatasourceImpl : PostDatasource {
    private val filePath = "posts.txt"
    private val file = File(filePath)

    override fun getPost(id: Int): Post {
        return Json.decodeFromString<List<Post>>(file.readText()).filter { it.id == id }[0]
    }

    override fun savePost(post: Post) {
        TODO("Not yet implemented")
    }

    override fun getAllPosts(): List<Post> {
        return Json.decodeFromString<List<Post>>(file.readText())
    }
}