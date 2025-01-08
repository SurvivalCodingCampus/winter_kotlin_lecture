package org.example.day15.data_source.photo

import org.example.day15.data_source.DataSource
import org.example.day15.model.Photo

interface PhotoDataSource : DataSource {
    suspend fun getPhotos(): List<Photo>
}