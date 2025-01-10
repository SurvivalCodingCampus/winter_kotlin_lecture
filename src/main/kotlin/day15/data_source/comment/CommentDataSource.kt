package day15.data_source.comment

import utils.network.ResponseResult
import day15.model.Comment

interface CommentDataSource {
    suspend fun getComments(): ResponseResult<List<Comment>>
}