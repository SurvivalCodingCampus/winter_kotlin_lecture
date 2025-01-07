package org.example.day15.repository_exam

import org.example.day15.repository_exam.data_source.MockCommentDataSourceImpl
import org.example.day15.repository_exam.repository.CommentRepositoryImpl

fun main() {
    val testMock = CommentRepositoryImpl(MockCommentDataSourceImpl())

    println("${testMock.getComments(1)}\n")
    println("${testMock.getComments(2)}\n")
    println("${testMock.getComments(3)}\n")
}