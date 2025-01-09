//package org.example.day15.Repository
//
//import CustomErrorHandler
//import TodoDataSource
//import org.example.day15.Model.Todo
//import org.example.day15.Utils.parseJson
//import org.example.day15.Utils.readJson
//
//
//open class TodoDataSourceImp(private val jsonDataSource: String) : TodoDataSource {
//    private var _todo: List<Todo> = parseJson(jsonDataSource)
//
//
//    override suspend fun getTodos(): List<Todo> {
//        return todo
//    }
//
//    override suspend fun getCompletedTodos(): List<Todo> {
//        try {
//            return todo.filter { todo -> todo.completed }
//        } catch (e: Exception) {
//            throw CustomErrorHandler("Unexpected Error")
//        }
//    }
//
//}
//
//
//const val todoDataSource = "./src/main/kotlin/day15/RawData/todos.json"
//
//open class TodoRepository : TodoDataSourceImp(readJson(todoDataSource)) {}
//
