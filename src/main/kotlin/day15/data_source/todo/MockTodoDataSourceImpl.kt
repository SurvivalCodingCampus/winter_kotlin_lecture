package day15.data_source.todo

//class MockTodoDataSourceImpl : TodoDataSource {
//    override suspend fun getTodos(): ResponseResult<List<Todo>> {
//        return safeCall {
//            Json.decodeFromString<List<Todo>>(Urls.TODO_LIST_JSON)
//        }
//    }
//}