package day15.repository.user

import io.kotest.common.runBlocking
import org.example.day15.data_source.user.MockUserDataSourceImpl
import org.example.day15.repository.user.UserRepositoryImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class UserRepositoryImplTest {
    val userRepository = UserRepositoryImpl(MockUserDataSourceImpl())
    /// 잘못된 데이터의 파싱 테스트는 추후에 Data Source 에서 테스트를 진행해야 한다.

    @Test
    fun getUsers() = runBlocking {
        val users = userRepository.getUsers()
        assertEquals("user 객체의 갯수는 10개 여야한다.", 10, users.size)
    }

    @Test
    fun getUsersTop10ByUserName() = runBlocking {
        val users = userRepository.getUsersTop10ByUserName()
        assertEquals("user 객체의 갯수는 10개 여야한다.", 10, users.size)

        /// 이름순으로 정렬되어야 한다.
        val sortedUsers = users.sortedBy { it.username }
        assertEquals("user 객체의 이름순으로 정렬되어야 한다.", sortedUsers, users)
    }

}