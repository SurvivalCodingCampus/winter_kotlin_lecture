package org.example.day14.todo

import org.example.day14.HttpRepository

interface TodoHttpRepository : HttpRepository {
    // baseUrl
    override val baseUrl: String
        get() = "https://jsonplaceholder.typicode.com/todos"

    suspend fun getTodo(id: Int): Todo

    suspend fun getTodos(): List<Todo>
}