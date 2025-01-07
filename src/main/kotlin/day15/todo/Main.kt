package org.hyunjung.day15.todo

import kotlinx.coroutines.runBlocking
import org.hyunjung.day15.todo.datasource.TodoDataSourceImpl
import org.hyunjung.day15.todo.repository.TodoRepositoryImpl

fun main() = runBlocking {
    val todoDataSource = TodoDataSourceImpl()
    val repository = TodoRepositoryImpl(todoDataSource)

    try {
        val todos = repository.getTodos()
        println("All Todos:")
        todos.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching photos: ${e.message}")
    }

    try {
        val todos = repository.getCompletedTodos()
        println("Completed Todos:")
        todos.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching photos: ${e.message}")
    }
}