package org.example.day17.data_source

import day17.dto.ContentDto
import org.example.day15.data_source.DataSource

interface ContentDataSource : DataSource {
    suspend fun getContents(): List<ContentDto>
}