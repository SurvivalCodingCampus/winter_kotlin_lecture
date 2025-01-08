package org.example.day15.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.fetchData
import org.example.day15.data.datasource.PostDataSource
import org.example.day15.data.model.Post
import org.example.day15.data.resource.BASE_URL

class PostRemoteDataSource : PostDataSource {
    override suspend fun getPost(id: Int): Flow<Post> = flow {
        emit(fetchData("$BASE_URL/posts?id=${id.toPositive()}"))
    }

    override suspend fun getPosts(page: Int): Flow<List<Post>> = flow {
        emit(fetchData<List<Post>>("$BASE_URL/posts?_page=${page.toPositive()}"))
    }

    override suspend fun getPosts(page: Int, limit: Int): Flow<List<Post>> = flow {
        emit(fetchData<List<Post>>("$$BASE_URL/posts?_page=${page.toPositive()}&_limit=${limit.toPositive()}"))
    }
}

private fun Int.toPositive(): Int = if (this < 1) 1 else this

