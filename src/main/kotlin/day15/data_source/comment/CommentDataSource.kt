package day15.data_source.comment

import day15.common.ResponseResult
import day15.model.Comment

interface CommentDataSource {
    suspend fun getComments(): ResponseResult<List<Comment>>
}