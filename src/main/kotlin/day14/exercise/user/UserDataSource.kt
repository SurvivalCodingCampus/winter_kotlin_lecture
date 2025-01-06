package day14.exercise.user

interface UserDataSource {
    // 복잡한 Json List를 List로 변환
    suspend fun getUsers(): List<User>
}