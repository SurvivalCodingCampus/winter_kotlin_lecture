package org.example.day15.repository_exam.data_source

import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.model.Album
import java.io.File

class MockAlbumDatasourceImpl : AlbumDatasource {
    private val filePath = "albums.txt"
    private val file = File(filePath)

    override fun getAlbum(id: Int): Album {
        TODO("Not yet implemented")
    }

    override fun saveAlbum(album: Album) {
        TODO("Not yet implemented")
    }

    override fun getAllAlbums(): List<Album> {
        return Json.decodeFromString<List<Album>>(file.readText())
    }
}