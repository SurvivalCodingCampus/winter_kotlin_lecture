package day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.MockPostDatasourceImpl
import org.example.day15.repository_exam.repository.PostRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RepositoryExam6Test {
    val test = PostRepositoryImpl(MockPostDatasourceImpl())

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `getPost(int id) 테스트`() = runBlocking {
        // 가져온 Post에서 원하는 데이터가 나오는지 확인
        assertEquals(1, test.getPost(1).userId)
        assertEquals(1, test.getPost(1).id)
        assertEquals(
            "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            test.getPost(1).title
        )
        assertEquals(
            "quia et suscipit\n" +
                    "suscipit recusandae consequuntur expedita et cum\n" +
                    "reprehenderit molestiae ut ut quas totam\n" +
                    "nostrum rerum est autem sunt rem eveniet architecto", test.getPost(1).body
        )
    }

    @Test
    fun `getPosts() 테스트`() = runBlocking {
        // 가져온 Post 개수 확인
        assertEquals(100, test.getPosts().size)

        println(test.getPosts()[0])
        // 가져온 Post에서 원하는 데이터가 나오는지 확인
        assertEquals(1, test.getPosts()[0].userId)
        assertEquals(1, test.getPosts()[0].id)
        assertEquals(
            "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            test.getPosts()[0].title
        )
        assertEquals(
            "quia et suscipit\n" +
                    "suscipit recusandae consequuntur expedita et cum\n" +
                    "reprehenderit molestiae ut ut quas totam\n" +
                    "nostrum rerum est autem sunt rem eveniet architecto", test.getPosts()[0].body
        )
    }

    @Test
    fun `getPosts(int page, int limit) 테스트`() = runBlocking {
        val page1 = test.getPosts(1, 3)
        val page2 = test.getPosts(2, 3)
        val page3 = test.getPosts(3, 3)


        // 페이지마다 가져온 Post 개수 확인
        assertEquals(3, page1.size)
        assertEquals(3, page2.size)
        assertEquals(3, page3.size)


        // 페이지1에서 가져온 Post에서 원하는 데이터가 나오는지 확인
        assertEquals(1, page1[0].userId)
        assertEquals(1, page1[0].id)
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", page1[0].title)
        assertEquals(
            "quia et suscipit\n" +
                    "suscipit recusandae consequuntur expedita et cum\n" +
                    "reprehenderit molestiae ut ut quas totam\n" +
                    "nostrum rerum est autem sunt rem eveniet architecto", page1[0].body
        )


        // 페이지2에서 가져온 Post에서 원하는 데이터가 나오는지 확인
        assertEquals(1, page2[0].userId)
        assertEquals(4, page2[0].id)
        assertEquals("eum et est occaecati", page2[0].title)
        assertEquals(
            "ullam et saepe reiciendis voluptatem adipisci\n" +
                    "sit amet autem assumenda provident rerum culpa\n" +
                    "quis hic commodi nesciunt rem tenetur doloremque ipsam iure\n" +
                    "quis sunt voluptatem rerum illo velit", page2[0].body
        )


        // 페이지3에서 가져온 Post에서 원하는 데이터가 나오는지 확인
        assertEquals(1, page3[0].userId)
        assertEquals(7, page3[0].id)
        assertEquals("magnam facilis autem", page3[0].title)
        assertEquals(
            "dolore placeat quibusdam ea quo vitae\n" +
                    "magni quis enim qui quis quo nemo aut saepe\n" +
                    "quidem repellat excepturi ut quia\n" +
                    "sunt ut sequi eos ea sed quas", page3[0].body
        )
    }

    @Test
    fun `getPosts(int page)애서 page가 1보다 작은 경우 테스트`() = runBlocking {
        val page = test.getPosts(-1)


        // 페이지마다 가져온 Post 개수 확인
        assertEquals(100, page.size)


        // 페이지1에서 가져온 Post에서 원하는 데이터가 나오는지 확인
        assertEquals(1, page[0].userId)
        assertEquals(1, page[0].id)
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", page[0].title)
        assertEquals(
            "quia et suscipit\n" +
                    "suscipit recusandae consequuntur expedita et cum\n" +
                    "reprehenderit molestiae ut ut quas totam\n" +
                    "nostrum rerum est autem sunt rem eveniet architecto", page[0].body
        )
    }

    @Test
    fun `getPosts(int page) 첫 페이지에 모든 Post를 주었을 때 테스트`() = runBlocking {
        val page1 = test.getPosts(1)
        val page2 = test.getPosts(2, 3)


        // 페이지1에서 가져온 Post 개수 확인
        assertEquals(100, page1.size)


        // 페이지1에서 가져온 Post에서 원하는 데이터가 나오는지 확인
        assertEquals(1, page1[0].userId)
        assertEquals(1, page1[0].id)
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", page1[0].title)
        assertEquals(
            "quia et suscipit\n" +
                    "suscipit recusandae consequuntur expedita et cum\n" +
                    "reprehenderit molestiae ut ut quas totam\n" +
                    "nostrum rerum est autem sunt rem eveniet architecto", page1[0].body
        )


        // 페이지2가 빈 리스트인지 확인
        assertEquals(0, page2.size)
        assertEquals(true, page2.isEmpty())
    }
}