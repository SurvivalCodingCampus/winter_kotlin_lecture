package org.example.day15.repository_exam.data_source

import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.model.Comment
import java.io.File


class MockCommentDatasourceImpl : MockCommentDatasource {
    private val filePath = "comments.txt"
    private val file = File(filePath)

    override fun getComment(id: Int): Comment? {
        TODO("Not yet implemented")
    }

    override fun saveComment(comment: Comment) {
        TODO("Not yet implemented")
    }

    override fun getAllComment(): List<Comment> {
        return Json.decodeFromString<List<Comment>>(file.readText())
    }
}