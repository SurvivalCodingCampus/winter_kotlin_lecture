package org.example.day15.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.day14.util.fetchData
import org.example.day15.data.datasource.CommentDataSource
import org.example.day15.data.model.Comment
import org.example.day15.data.resource.BASE_URL

class CommentRemoteDataSource : CommentDataSource {
    override suspend fun getComments(postId: Int): Flow<List<Comment>> = flow {
        emit(fetchData<List<Comment>>("$BASE_URL/comments?postId=${postId}"))
    }
}