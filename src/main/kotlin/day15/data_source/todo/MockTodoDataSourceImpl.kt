package day15.data_source.todo

import day15.common.ResponseResult
import day15.common.safeCall
import day15.model.Todo
import day15.util.Urls
import kotlinx.serialization.json.Json

class MockTodoDataSourceImpl : TodoDataSource {
    override suspend fun getTodos(): ResponseResult<List<Todo>> {
        return safeCall {
            Json.decodeFromString<List<Todo>>(Urls.TODO_LIST_JSON)
        }
    }
}