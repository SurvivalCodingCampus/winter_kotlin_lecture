package org.example.day15.Repository

import AlbumDataSource
import AlbumRepositoryImpl
import org.example.day15.Model.Album
import org.example.day15.Utils.parseJson


open class AlbumDataSourceImpl(private val jsonFilePath: String) : AlbumRepositoryImpl, AlbumDataSource {
    override val albums: List<Album>
        get() = parseJson(jsonFilePath)

    override suspend fun getAlbums(limit: Int?): List<Album> {
        if (albums.isEmpty()) emptyList<String?>()
        if (limit != null) {
            return if (limit > 0) albums.slice(0..<limit) else albums
        }
        return albums
    }
}


const val albumDataSource = "./src/main/kotlin/day15/RawData/albums.json"

class AlbumRepository : AlbumDataSourceImpl(albumDataSource) {}
