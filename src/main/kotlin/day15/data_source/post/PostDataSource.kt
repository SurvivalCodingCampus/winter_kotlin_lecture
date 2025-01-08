package org.example.day15.data_source.post

import org.example.day15.data_source.DataSource
import org.example.day15.model.Post

interface PostDataSource : DataSource {
    suspend fun getPosts(): List<Post>
}