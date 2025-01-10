package day17.dataSource

import day17.dto.MaskStoreDto
import day17.dto.Pharmacy

class MockMaskStoreDataSourceImpl : MaskStoreDataSource {
    companion object {
        private val dummyStores = listOf(
            Pharmacy(
                addr = "서울특별시 강북구 솔매로 38 (미아동)",
                code = "11817488",
                createdAt = "2020/07/03 11:00:00",
                lat = 37.6254369,
                lng = 127.0164096,
                name = "승약국",
                remainStat = "plenty",
                stockAt = "2020/07/02 18:05:00",
                type = "01"
            ),
            Pharmacy(
                addr = "서울특별시 강북구 삼양로 247 3층 (미아동)",
                code = "12856941",
                createdAt = "2020/07/03 11:00:00",
                lat = 37.6255182,
                lng = 127.017747,
                name = "대지약국",
                remainStat = "plenty",
                stockAt = "2020/07/03 10:45:00",
                type = "01"
            )
        )
    }
    override suspend fun getStores(): MaskStoreDto = MaskStoreDto(
        count = dummyStores.size,
        stores = dummyStores
    )

    override suspend fun getStore(name: String): Pharmacy? = Companion.dummyStores.find { it.name == name }

}