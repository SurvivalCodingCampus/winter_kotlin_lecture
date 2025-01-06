import org.junit.Assert.*
import org.junit.Test
import kotlinx.coroutines.runBlocking
import org.example.day14.StockDataSourceImpl

class StockDataSourceImplTest {

    private val filePath = "listing_status.csv"
    private val stockDataSource = StockDataSourceImpl(filePath)

    @Test
    fun `getStockListings가 올바른 주식 목록을 반환한다`() = runBlocking {
        val listings = stockDataSource.getStockListings()

        // 첫 번째 주식 항목이 예상된 형식에 맞는지 확인
        val firstListing = listings[0]
        assertEquals("A", firstListing.symbol)
        assertEquals("Agilent Technologies Inc", firstListing.name)
        assertEquals("NYSE", firstListing.exchange)
        assertEquals("Stock", firstListing.assetType)
        assertEquals("1999-11-18", firstListing.ipoDate)
        assertEquals(null, firstListing.delistingDate)
        assertEquals("Active", firstListing.status)
    }

    @Test
    fun `symbol 값이 없는 항목은 제외된다`() = runBlocking {
        val listings = stockDataSource.getStockListings()

        // symbol 값이 비어있는 항목이 제외되었는지 확인
        listings.forEach { listing ->
            assertTrue(listing.symbol.isNotBlank())
        }
    }
}