import org.example.day15.Model.Todo

interface TodoRepositoryImpl {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
}


interface TodoDataSource {
    val todo: List<Todo>
}
