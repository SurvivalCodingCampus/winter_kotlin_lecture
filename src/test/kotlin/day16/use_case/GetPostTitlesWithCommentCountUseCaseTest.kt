package day16.use_case

import kotlinx.coroutines.runBlocking
import org.example.core.VoidParams
import org.example.day15.data_source.comment.MockCommentDataSourceImpl
import org.example.day15.data_source.post.MockPostDataSourceImpl
import org.example.day15.repository.comment.CommentRepositoryImpl
import org.example.day15.repository.post.PostRepositoryImpl
import org.example.day16.use_case.GetAndPrintPostTitlesWithCommentCountUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class GetPostTitlesWithCommentCountUseCaseTest {
    private val mockPostJson = """
[
    {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    },
    {
        "userId": 1,
        "id": 2,
        "title": "qui est esse",
        "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
    }
]
    """.trimIndent()

    private val mockCommentJson = """
[
    {
    "postId": 1,
    "id": 1,
    "name": "id labore ex et quam laborum",
    "email": "Eliseo@gardner.biz",
    "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
    },
    {
        "postId": 1,
        "id": 2,
        "name": "quo vero reiciendis velit similique earum",
        "email": "Jayne_Kuhic@sydney.com",
        "body": "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et"
    },
    {
        "postId": 1,
        "id": 3,
        "name": "odio adipisci rerum aut animi",
        "email": "Nikita@garfield.biz",
        "body": "quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione"
    },
    {
        "postId": 1,
        "id": 4,
        "name": "alias odio sit",
        "email": "Lew@alysha.tv",
        "body": "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati"
    },
    {
        "postId": 1,
        "id": 5,
        "name": "vero eaque aliquid doloribus et culpa",
        "email": "Hayden@althea.biz",
        "body": "harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et"
    },
    {
        "postId": 2,
        "id": 6,
        "name": "et fugit eligendi deleniti quidem qui sint nihil autem",
        "email": "Presley.Mueller@myrl.com",
        "body": "doloribus at sed quis culpa deserunt consectetur qui praesentium\naccusamus fugiat dicta\nvoluptatem rerum ut voluptate autem\nvoluptatem repellendus aspernatur dolorem in"
    },
    {
        "postId": 2,
        "id": 7,
        "name": "repellat consequatur praesentium vel minus molestias voluptatum",
        "email": "Dallas@ole.me",
        "body": "maiores sed dolores similique labore et inventore et\nquasi temporibus esse sunt id et\neos voluptatem aliquam\naliquid ratione corporis molestiae mollitia quia et magnam dolor"
    },
    {
        "postId": 2,
        "id": 8,
        "name": "et omnis dolorem",
        "email": "Mallory_Kunze@marie.org",
        "body": "ut voluptatem corrupti velit\nad voluptatem maiores\net nisi velit vero accusamus maiores\nvoluptates quia aliquid ullam eaque"
    },
    {
        "postId": 2,
        "id": 9,
        "name": "provident id voluptas",
        "email": "Meghan_Littel@rene.us",
        "body": "sapiente assumenda molestiae atque\nadipisci laborum distinctio aperiam et ab ut omnis\net occaecati aspernatur odit sit rem expedita\nquas enim ipsam minus"
    },
    {
        "postId": 2,
        "id": 10,
        "name": "eaque et deleniti atque tenetur ut quo ut",
        "email": "Carmen_Keeling@caroline.name",
        "body": "voluptate iusto quis nobis reprehenderit ipsum amet nulla\nquia quas dolores velit et non\naut quia necessitatibus\nnostrum quaerat nulla et accusamus nisi facilis"
    }
]
    """.trimIndent()
    private val postRepository = PostRepositoryImpl(MockPostDataSourceImpl(mockPostJson))
    private val commentRepository = CommentRepositoryImpl(MockCommentDataSourceImpl(mockCommentJson))
    private val useCase = GetAndPrintPostTitlesWithCommentCountUseCase(postRepository, commentRepository)

    @Test
    fun execute() = runBlocking {
        val result = useCase.call(VoidParams())
        assertEquals("포스트의 갯수는 2개 여야 한다.", 2, result.size)
        assertEquals(
            "첫번째 포스트의 재목은 다음과 같아야 한다.",
            "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            result[0].postTitle
        )
        assertEquals("첫번째 포스트의 댓글 수는 5개 여야 한다.", 5, result[0].commentCount)
        assertEquals("두번째 포스트의 재목은 다음과 같아야 한다.", "qui est esse", result[1].postTitle)
        assertEquals("두번째 포스트의 댓글 수는 5개 여야 한다.", 5, result[1].commentCount)
    }

}