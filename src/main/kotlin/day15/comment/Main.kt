package org.hyunjung.day15.comment

import kotlinx.coroutines.runBlocking
import org.hyunjung.day15.comment.datasource.MockCommentDataSourceImpl
import org.hyunjung.day15.comment.datasource.RemoteCommentDataSourceImpl
import org.hyunjung.day15.comment.repository.CommentRepositoryImpl

fun main() = runBlocking {
    val remoteDataSource = RemoteCommentDataSourceImpl()
    val mockDataSource = MockCommentDataSourceImpl()

    val repository = CommentRepositoryImpl(remoteDataSource, mockDataSource)

    try {
        val comments = repository.getComments(1)
        println("Fetched Comments:")
        comments.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching comments: ${e.message}")
    }
}