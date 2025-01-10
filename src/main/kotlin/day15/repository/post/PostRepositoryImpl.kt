package day15.repository.post

import utils.network.ResponseResult
import day15.data_source.post.PostDataSource
import day15.model.Post

class PostRepositoryImpl(
    private val postDataSource: PostDataSource
) : PostRepository {
    override suspend fun getPost(id: Int): Post? {
        return when (val result = postDataSource.getPosts()) {
            is ResponseResult.Success -> {
                result.data.find { it.id == id }
            }

            is ResponseResult.Failure -> {
                null
            }
        }
    }

    override suspend fun getPosts(page: Int, limit: Int?): List<Post> {
        return when (val result = postDataSource.getPosts()) {
            is ResponseResult.Success -> {

                val checkPage = if (page <= 1) 1 else page

                return if (limit == null) {
                    result.data
                } else {
                    result.data.slice((checkPage - 1) * limit..<(checkPage * limit))
                }
            }

            is ResponseResult.Failure -> {
                // 실패시 작업..
                emptyList()
            }
        }
    }
}