import org.example.day15.Model.Album

interface AlbumRepositoryImpl {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}

interface AlbumDataSource {
    val albums: List<Album>
}
