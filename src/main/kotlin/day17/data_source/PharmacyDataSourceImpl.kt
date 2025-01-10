import day17.PharmacyDto
import day17.PharmacyDataSource
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import org.example.day15.Utils.format

class PharmacyDataSourceImpl(
    private val client: HttpClient = HttpClient(CIO)
) : PharmacyDataSource {
    override suspend fun fetchStoreData(url: String): List<Store> {
        val response = client.get(url)

        println(response.bodyAsText())
        println(format.decodeFromString<PharmacyDto>(response.bodyAsText()))

        return format.decodeFromString<PharmacyDto>(response.bodyAsText()).stores?.map { store -> store.toStore() }
            ?: emptyList()
    }
}
