package org.example.day15.data_source.comment

import org.example.day15.data_source.DataSource
import org.example.day15.model.Comment

interface CommentDataSource : DataSource {

    suspend fun getComments(): List<Comment>

}