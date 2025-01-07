import org.example.day15.Model.Photo

interface PhotoRepositoryImpl {
    suspend fun getPhotos(albumId: Int): List<Photo>
}

interface PhotoDataSource {
    val photos: List<Photo>
}
