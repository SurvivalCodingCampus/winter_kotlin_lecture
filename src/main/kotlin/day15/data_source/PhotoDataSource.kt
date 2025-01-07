package day15.data_source

import day15.model.Photo

interface PhotoDataSource {
    fun getPhotos(): List<Photo>
}