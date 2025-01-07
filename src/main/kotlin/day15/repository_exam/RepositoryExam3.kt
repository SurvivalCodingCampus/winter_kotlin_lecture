package org.example.day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.TodoDatasourceImpl
import org.example.day15.repository_exam.repository.TodoRepositoryImpl

fun main() = runBlocking {
    val test = TodoRepositoryImpl(TodoDatasourceImpl())

    println(test.getTodos())
    println(test.getCompletedTodos())
}