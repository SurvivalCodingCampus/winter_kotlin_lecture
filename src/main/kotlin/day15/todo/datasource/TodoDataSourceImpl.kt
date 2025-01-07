package org.hyunjung.day15.todo.datasource

import org.hyunjung.day15.todo.model.Todo
import org.hyunjung.day15.util.Constants
import org.hyunjung.day15.util.JsonParser
import org.hyunjung.day15.util.NetworkUtils

class TodoDataSourceImpl : TodoDataSource {

    override suspend fun getTodos(): List<Todo> {
        val url = "${Constants.BASE_URL}/todos"
        return NetworkUtils.executeRequest(url) { response ->
            JsonParser.parseJson(response)
        }
    }

    override suspend fun getCompletedTodos(): List<Todo> {
        val url = "${Constants.BASE_URL}/todos?completed=true"
        return NetworkUtils.executeRequest<List<Todo>>(url) { response ->
            JsonParser.parseJson(response)
        }
    }
}