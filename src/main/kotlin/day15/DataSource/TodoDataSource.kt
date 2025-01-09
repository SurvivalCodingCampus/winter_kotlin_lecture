import org.example.day15.Model.Todo

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos(): List<Todo>
    suspend fun getTodo(id: Int): Todo
}

