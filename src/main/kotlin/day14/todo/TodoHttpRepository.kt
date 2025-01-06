package org.example.day14.todo

import org.example.day14.HttpRepository

interface TodoHttpRepository : HttpRepository {
    // baseUrl
    override val baseUrl: String

    suspend fun getTodo(id: Int): Todo

    suspend fun getTodos(): List<Todo>
}