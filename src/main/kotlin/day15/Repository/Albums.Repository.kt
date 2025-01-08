package org.example.day15.Repository

import AlbumDataSource
import AlbumRepositoryImpl
import org.example.day15.Model.Album
import org.example.day15.Model.Photo
import org.example.day15.Utils.parseJson
import org.example.day15.Utils.readJson


open class AlbumDataSourceImpl(private val jsonDataSource: String) : AlbumRepositoryImpl, AlbumDataSource {
    private var _album: List<Album> = parseJson(jsonDataSource)

    override val albums: List<Album>
        get() = _album

    override suspend fun getAlbums(limit: Int?): List<Album> {
        if (limit == null) return albums

        return if (limit > 0) albums.slice(0..<limit) else albums
    }
}


const val albumDataSource = "./src/main/kotlin/day15/RawData/albums.json"

class AlbumRepository : AlbumDataSourceImpl(readJson(albumDataSource)) {}
