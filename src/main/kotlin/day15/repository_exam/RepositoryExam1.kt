package org.example.day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.MockCommentDataSourceImpl
import org.example.day15.repository_exam.repository.CommentRepositoryImpl

fun main(): Unit = runBlocking {
    val testMock = CommentRepositoryImpl(MockCommentDataSourceImpl())
    
    println("${testMock.getComments(1)}\n")
    println("${testMock.getComments(2)}\n")
    println("${testMock.getComments(3)}\n")

}