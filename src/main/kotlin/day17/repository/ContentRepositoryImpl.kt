package org.example.day17.repository

import org.example.day17.data_source.ContentDataSource
import org.example.day17.mapper.toModel
import org.example.day17.model.Content

class ContentRepositoryImpl(override val dataSource: ContentDataSource) : ContentRepository {
    override suspend fun getContents(): List<Content> {
        return dataSource.getContents().map { it.toModel() }
    }
}