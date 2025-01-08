package org.example.day15.repository_exam.data_source

import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.model.Comment
import java.io.File


class MockCommentDatasourceImpl : CommentDatasource {
    private val filePath = "comments.txt"
    private val file = File(filePath)

    override suspend fun getComment(id: Int): Comment? {
        TODO("Not yet implemented")
    }

    override suspend fun saveComment(comment: Comment) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllComment(): List<Comment> {
        return Json.decodeFromString<List<Comment>>(file.readText())
    }
}