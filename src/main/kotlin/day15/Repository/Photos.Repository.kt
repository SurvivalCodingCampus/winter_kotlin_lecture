package org.example.day15.Repository


import PhotoDataSource
import PhotoRepositoryImpl
import org.example.day15.Model.Photo
import org.example.day15.Model.User
import org.example.day15.Utils.parseJson
import org.example.day15.Utils.readJson


open class PhotoDataSourceImpl(private val jsonDataSource: String) : PhotoDataSource, PhotoRepositoryImpl {
    private var _photo: List<Photo> = parseJson(jsonDataSource)

    override val photos: List<Photo>
        get() = _photo

    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return photos.filter { photo -> photo.albumId == albumId }
    }
}


const val photoDataSource = "./src/main/kotlin/day15/RawData/photos.json"

class PhotoRepository : PhotoDataSourceImpl(readJson(photoDataSource)) {
}

