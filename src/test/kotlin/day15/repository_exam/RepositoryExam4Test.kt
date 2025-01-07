package day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.model.user.Address
import org.example.day15.repository_exam.data_source.UserDatasourceImpl
import org.example.day15.repository_exam.model.user.Company
import org.example.day15.repository_exam.model.user.Geo
import org.example.day15.repository_exam.repository.UserRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RepositoryExam4Test {
    private val test = UserRepositoryImpl(UserDatasourceImpl())

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `getUsers() 테스트`() = runBlocking {

        // 가져온 User 개수 확인
        assertEquals(10, test.getUsers().size)

        // 가져온 User에서 원하는 데이터가 나오는지 확인
        assertEquals(1, test.getUsers()[0].id)
        assertEquals("Leanne Graham", test.getUsers()[0].name)
        assertEquals("Bret", test.getUsers()[0].username)
        assertEquals("Sincere@april.biz", test.getUsers()[0].email)
        assertEquals(
            Address("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", Geo("-37.3159", "81.1496")),
            test.getUsers()[0].address
        )
        assertEquals("1-770-736-8031 x56442", test.getUsers()[0].phone)
        assertEquals("hildegard.org", test.getUsers()[0].website)
        assertEquals(
            Company(
                "Romaguera-Crona",
                "Multi-layered client-server neural-net",
                "harness real-time e-markets"
            ), test.getUsers()[0].company
        )
    }

    @Test
    fun `getCompletedTodos() 테스트`() = runBlocking {

        // 가져온 User 개수 확인 (10개)
        assertEquals(10, test.getUsersTop10ByUserName().size)

        // 가져온 User들이 username을 기준으로 정렬되었나 확인
        for (i in 0..9) {
            when (i) {
                0 -> assertEquals("Antonette", test.getUsersTop10ByUserName()[i].username)
                1 -> assertEquals("Bret", test.getUsersTop10ByUserName()[i].username)
                2 -> assertEquals("Delphine", test.getUsersTop10ByUserName()[i].username)
                3 -> assertEquals("Elwyn.Skiles", test.getUsersTop10ByUserName()[i].username)
                4 -> assertEquals("Kamren", test.getUsersTop10ByUserName()[i].username)
                5 -> assertEquals("Karianne", test.getUsersTop10ByUserName()[i].username)
                6 -> assertEquals("Leopoldo_Corkery", test.getUsersTop10ByUserName()[i].username)
                7 -> assertEquals("Maxime_Nienow", test.getUsersTop10ByUserName()[i].username)
                8 -> assertEquals("Moriah.Stanton", test.getUsersTop10ByUserName()[i].username)
                9 -> assertEquals("Samantha", test.getUsersTop10ByUserName()[i].username)
            }
        }


        // 가져온 User에서 원하는 데이터가 나오는지 확인
        assertEquals(2, test.getUsersTop10ByUserName()[0].id)
        assertEquals("Ervin Howell", test.getUsersTop10ByUserName()[0].name)
        assertEquals("Antonette", test.getUsersTop10ByUserName()[0].username)
        assertEquals("Shanna@melissa.tv", test.getUsersTop10ByUserName()[0].email)
        assertEquals(
            Address("Victor Plains", "Suite 879", "Wisokyburgh", "90566-7771", Geo("-43.9509", "-34.4618")),
            test.getUsersTop10ByUserName()[0].address
        )
        assertEquals("010-692-6593 x09125", test.getUsersTop10ByUserName()[0].phone)
        assertEquals("anastasia.net", test.getUsersTop10ByUserName()[0].website)
        assertEquals(
            Company(
                "Deckow-Crist",
                "Proactive didactic contingency",
                "synergize scalable supply-chains"
            ), test.getUsersTop10ByUserName()[0].company
        )
    }
}