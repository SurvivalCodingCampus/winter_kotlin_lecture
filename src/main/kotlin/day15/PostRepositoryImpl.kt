package day15

import day15.data.PostDataSource
import day15.models.Post

class PostRepositoryImpl(private val source: PostDataSource) : PostRepository {
    override suspend fun findById(id: Int): Post? = source.getPosts().find { it.id == id }
    override suspend fun paginated(pageIndex: Int, pageSize: Int?): List<Post> =
        source.getPosts().let {
            it.subList(
                (pageSize ?: 0) * pageIndex.coerceIn(1, it.size.floorDiv((pageSize ?: 1))),
                pageSize ?: it.lastIndex
            )
        }
}