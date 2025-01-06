package day14

interface TodoDataSource {
    suspend fun getTodos(): List<Todo>
}