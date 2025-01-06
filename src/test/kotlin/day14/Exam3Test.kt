package day14

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.day14.UserDataSourceImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class Exam3Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `연습문제 3번 테스트`(): Unit = runBlocking {
        val test = UserDataSourceImpl()

        launch {
            assertEquals(1, test.getUsers()[0].id)
            assertEquals("Leanne Graham", test.getUsers()[0].name)
            assertEquals("Bret", test.getUsers()[0].username)
            assertEquals("Sincere@april.biz", test.getUsers()[0].email)
            assertEquals("Address(street=Kulas Light, suite=Apt. 556, city=Gwenborough, zipcode=92998-3874, geo=Geo(lat=-37.3159, lng=81.1496))", test.getUsers()[0].address.toString())
            assertEquals("1-770-736-8031 x56442", test.getUsers()[0].phone)
            assertEquals("hildegard.org", test.getUsers()[0].website)
            assertEquals("Company(name=Romaguera-Crona, catchPhrase=Multi-layered client-server neural-net, bs=harness real-time e-markets)", test.getUsers()[0].company.toString())

            // Address 테스트
            assertEquals("Kulas Light", test.getUsers()[0].address.street)
            assertEquals("Apt. 556", test.getUsers()[0].address.suite)
            assertEquals("Gwenborough", test.getUsers()[0].address.city)
            assertEquals("92998-3874", test.getUsers()[0].address.zipcode)
            assertEquals("Geo(lat=-37.3159, lng=81.1496)", test.getUsers()[0].address.geo.toString())

            // Geo 테스트
            assertEquals("-37.3159", test.getUsers()[0].address.geo.lat)
            assertEquals("81.1496", test.getUsers()[0].address.geo.lng)

            // Company 테스트
            assertEquals("Romaguera-Crona", test.getUsers()[0].company.name)
            assertEquals("Multi-layered client-server neural-net", test.getUsers()[0].company.catchPhrase)
            assertEquals("harness real-time e-markets", test.getUsers()[0].company.bs)
        }
    }
}