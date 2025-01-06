package day14.exercise.todo

interface TodoDataSource {
    // 간단한 JSON을 데이터 클래스로 변환
    suspend fun getTodo(): Todo

    // Json List를 List<Todo>로 변환
    suspend fun getTodos(): List<Todo>


}


