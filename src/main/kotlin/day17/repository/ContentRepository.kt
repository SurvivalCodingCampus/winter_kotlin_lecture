package org.example.day17.repository

import org.example.day17.data_source.ContentDataSource
import org.example.day17.model.Content

interface ContentRepository {
    val dataSource: ContentDataSource
    suspend fun getContents(): List<Content>
}