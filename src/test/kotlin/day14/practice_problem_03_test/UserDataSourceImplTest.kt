package day14.practice_problem_03_test

import day14.practice_problem_03.User
import day14.practice_problem_03.UserDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class UserDataSourceImplTest {

    @Test
    fun getUsers() = runBlocking {
        val usersDataList: List<User> = UserDataSourceImpl().getUsers()

        // 자료가 모두 리스트에 들어 왔는지
        assertEquals(10, usersDataList.size)

        // 인덱스 1을 대상으로 저장 값들 확인
        assertEquals(2, usersDataList[1].id)
        assertEquals("Ervin Howell", usersDataList[1].name)
        assertEquals("Antonette", usersDataList[1].username)
        assertEquals("Shanna@melissa.tv", usersDataList[1].email)
        assertEquals("Victor Plains", usersDataList[1].address.street)
        assertEquals("Suite 879", usersDataList[1].address.suite)
        assertEquals("Wisokyburgh", usersDataList[1].address.city)
        assertEquals("90566-7771", usersDataList[1].address.zipcode)
        assertEquals("-43.9509", usersDataList[1].address.geo.lat)
        assertEquals("-34.4618", usersDataList[1].address.geo.lng)
        assertEquals("010-692-6593 x09125", usersDataList[1].phone)
        assertEquals("anastasia.net", usersDataList[1].website)
        assertEquals("Deckow-Crist", usersDataList[1].company.name)
        assertEquals("Proactive didactic contingency", usersDataList[1].company.catchPhrase)
        assertEquals("synergize scalable supply-chains", usersDataList[1].company.bs)


    }
}