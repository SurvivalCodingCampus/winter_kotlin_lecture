package day14

interface TodoDataSource {
    suspend fun getTodo(): Todo
}